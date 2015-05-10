package com.crazy.chapter9;

public class Season {

	private String name;
	private String desc;

	private static final Season SPRING = new Season("春天", "春意盎然");
	private static final Season SUMMER = new Season("夏天", "夏日炎炎");
	private static final Season FALL = new Season("秋天", "秋高气爽");
	private static final Season WINTER = new Season("冬天", "微露上学");

	private Season(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}

	public static Season getSeason(int seasonNum) {
		switch (seasonNum) {
		case 1:
			return SPRING;
		case 2:
			return SUMMER;
		case 3:
			return FALL;
		case 4:
			return WINTER;
		default:
			return null;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Season(Season s){
		System.out.println(s.getName() + "," + s.getDesc());
	}
	public static void main(String[] args){
		new Season(Season.FALL);
	}
}
