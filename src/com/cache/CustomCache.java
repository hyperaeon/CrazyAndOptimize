package com.cache;

import lombok.Builder;
import lombok.Data;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author ly
 * @description
 * @date 2019/5/20 0020
 * @time 14:17
 */
public class CustomCache {

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    private Map<String, Value> map;

    private int cacheSize = 1024;

    public CustomCache() {
        map = new ConcurrentHashMap<>(cacheSize);
    }

    public CustomCache(int size) {
        this.cacheSize = size;
        map = new ConcurrentHashMap<>(size);
    }

    /**
     * 添加到缓存
     * @param key
     * @param data
     * @return
     */
    public boolean putCache(String key, Object data) {
        return this.putCache(key, data, 0L);
    }

    /**
     * 添加到缓存，失效时间为expire
     * @param key
     * @param data
     * @param expire
     * @return
     */
    public boolean putCache(String key, Object data, long expire) {
        Value oldValue = map.get(key);
        long currentTime = System.currentTimeMillis();
        if (oldValue != null) {
            //已经存在，则直接覆盖
            oldValue.setValue(data);
            oldValue.setExpireTime(currentTime + expire);
            oldValue.setLatestAccessTime(currentTime);
            return true;
        }
        if (cacheSize() >= cacheSize) {
            removeOldestCache();
        }
        Value newValue = Value.builder()
                .value(data)
                .expireTime(currentTime + expire)
                .latestAccessTime(currentTime)
                .build();
        map.put(key, newValue);
        return true;
    }

    /**
     * 获取缓存的大小
     * @return
     */
    public int cacheSize(){
        return map.size();
    }
    private static final int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    /**
     * 获取缓存的值，更新Value中的latestAccessTime
     * @param key
     * @return
     */
    public Object getCache(String key) {
        Value value = map.get(key);
        if (value == null) {
            return null;
        }
        if (value.getExpireTime() < System.currentTimeMillis()) {
            //惰性删除
            removeCache(key);
            return null;
        }
        value.setLatestAccessTime(System.currentTimeMillis());
        return value.getValue();
    }
    /**
      * @description 移除最早访问的key
      * @return void
      * @date 2019/5/20 0020
      * @time 15:48
     */
    private void removeOldestCache() {
        String oldestKey = this.getOldestKey();
        if (map.get(oldestKey) != null) {
            map.remove(oldestKey);
        }
    }

    /**
     * 获取value中的latestAccessTime最小的key
     * @return
     */
    private String getOldestKey() {
        if (cacheSize() <= 0) {
            return null;
        }
        Comparator<Value> comparator = Comparator.comparing(Value::getLatestAccessTime);
        List<String> sortedKey = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(comparator))
                .map(e -> e.getKey()).collect(Collectors.toList());
        return sortedKey.get(0);
    }

    /**
     * 移除缓存
     * @param key
     */
    private void removeCache(String key) {
        map.remove(key);
    }

    public static void main(String[] args) throws Exception {
        CustomCache customCache = new CustomCache(2);
        customCache.putCache("abc", "abc");
        Thread.sleep(200L);
        customCache.putCache("bcd", "bcd");
        customCache.putCache("def", "def");
        Object obj = customCache.getCache("abc");
        System.out.println(obj);
        int c = 7;
        System.out.println(tableSizeFor(c));
    }

}

@Data
@Builder
class Value {

    /**
     * 缓存的值
     */
    private Object value;

    /**
     * 缓存的失效时间戳
     */
    @Builder.Default
    private long expireTime = 0;

    /**
     * 缓存最近访问时间
     */
    private long latestAccessTime;

}
