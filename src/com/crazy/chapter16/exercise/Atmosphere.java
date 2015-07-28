package com.crazy.chapter16.exercise;

public class Atmosphere {

	private double temperature;
	private double moisture;
	private double windSpeed;

	private boolean flag = false;

	public Atmosphere(double temperature, double moisture, double windSpeed) {
		this.temperature = temperature;
		this.moisture = moisture;
		this.windSpeed = windSpeed;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getMoisture() {
		return moisture;
	}

	public void setMoisture(double moisture) {
		this.moisture = moisture;
	}

	public double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public synchronized void measure(double temperature) {
		try {
			if (!flag) {
				wait();
			} else {
				System.out.println("测量温度：" + temperature);
				Thread.sleep(5000);
				flag = false;
				notifyAll();
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
	
	public synchronized void read(double temperature) {
		try {
			if (flag) {
				wait();
			} else {
				System.out.println("读取数据：" + temperature);
				Thread.sleep(10);
				flag = true;
				notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
