package com.effective.chapter3;

import org.springframework.beans.BeanUtils;

public class ColorPointCopyTest {

	public static void main(String[] args) {
		Color c1 = new Color();
		ColorPoint cp1 = new ColorPoint();
		cp1.setColor(c1);
		c1.setColor(1);
		ColorPoint cp2 = new ColorPoint();
		BeanUtils.copyProperties(cp1, cp2);
		System.out.println(cp1.getColor() == cp2.getColor());
		System.out.println(cp1.getColor().getColor() == cp2.getColor().getColor());
	}
}
