/**
 * 
 */
package com.effective.chapter3;

/**
 * @author hzliyong
 *
 */
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
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof ColorPoint)) {
			return false;
		}
		ColorPoint cp = (ColorPoint) o;
		return cp.point.equals(point) && cp.color.equals(color); 
	}
}
