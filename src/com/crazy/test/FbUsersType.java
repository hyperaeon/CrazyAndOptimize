/*
 * 项目�?      农夫山泉小瓶水系�?
 * 文件�?      YesOrNoType.java
 * 类名:        YesOrNoType
 *
 * 版权声明:
 *      本系统的�?��内容，包括源码�?页面设计，文字�?图像以及其他任何信息�?
 *      如未经特殊说明，其版权均属农夫山泉股份有限公司所有�?
 *
 *      Copyright (c) 2013 �com.yst.nfsqcom.crazy.test��
 */
package com.crazy.test;

/**
 * 类名:      FbUsersType
 * 描述�?              1 or 2
 *
 */
public enum FbUsersType {

    DEALER(2, "abc"), UMEMBODY(1, "编外"), UNKNOWN(-1, "未知");

    private Integer type;

    private String desc;


    private FbUsersType(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static FbUsersType getStaffType(Integer ty) {
        for (FbUsersType type : values()) {
            if (type.getType().equals(ty)) {
                return type;
            }
        }
        return UNKNOWN;
    }

}
