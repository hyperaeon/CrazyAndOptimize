package com.effective.duplicate.chapter2;

import com.effective.chapter3.Color;
import com.effective.chapter3.Point;

public class ColorPoint {

	
	private final Point point;
	
	private final Color color;
	
	public ColorPoint(int x, int y, Color color) {
		if (color == null) {
			throw new NullPointerException();
		}
		point = new Point(x, y);
		this.color = color;
	}
	
	public Point asPoint() {
		return point;
	}
	
	public boolean equals(Object o) {
		if (!(o instanceof ColorPoint)) {
			return false;
		}
		ColorPoint cp = (ColorPoint)o;
		return cp.point.equals(point) && cp.color.equals(color);
				
	}
}
