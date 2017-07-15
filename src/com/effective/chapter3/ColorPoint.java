/**
 * 
 */
package com.effective.chapter3;

/**
 * @author hzliyong
 *
 */
public class ColorPoint {

	private Point point;
	private Color color;
	
	public ColorPoint() {
		
	}
	
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
	
	public Point getPoint() {
		return point;
	}

	public Color getColor() {
		return color;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public void setColor(Color color) {
		this.color = color;
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
