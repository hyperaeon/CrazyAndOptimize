package com.designpattern.facade.derail;

public class SwitchFacade {

	private Fan fan;
	
	private Fridge fridge;
	
	private Light light;
	
	private Television television;
	
	public SwitchFacade() {
		fan = new Fan();
		fridge = new Fridge();
		light = new Light();
		television = new Television();
	}
	
	public void change(boolean isOpen) {
		if (isOpen) {
			System.out.println("白天，所有电源都关闭");
			fan.off();
			fridge.off();
			light.off();
			television.off();
		} else {
			System.out.println("晚上，所有电源都打开");
			fan.on();
			fridge.on();
			light.on();
			television.on();
		}
	}
}
