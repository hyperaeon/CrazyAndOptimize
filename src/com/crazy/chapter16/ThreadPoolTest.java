package com.crazy.chapter16;

import java.lang.management.ManagementFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.sun.management.OperatingSystemMXBean;

class Thread_Pool implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

}

public class ThreadPoolTest {

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(6);
		// es.submit(new Thread_Pool());
		// es.submit(new Thread_Pool());
		// es.shutdown();F

		System.out.println(Runtime.getRuntime().totalMemory() / 1024);
		System.out.println(System.getProperty("os.name"));
		OperatingSystemMXBean osm = (OperatingSystemMXBean) ManagementFactory
				.getOperatingSystemMXBean();
		System.out.println(osm.getTotalPhysicalMemorySize()/1024);
		System.out.println(Runtime.getRuntime().availableProcessors());
	}
}
