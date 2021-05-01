package com.hadoop;

import org.apache.hadoop.conf.Configuration;

public class ConfigurationTest {

	public static void main(String[] args) {
		Configuration conf = new Configuration();
		conf.addResource("C:/Users/ly/git/CrazyAndOptimize/src/com/hadoop/configuration-1.xml");
		System.out.println(conf.get("color"));
		System.out.println(conf.get("size"));
	}
}
