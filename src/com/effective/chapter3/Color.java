/**
 * 
 */
package com.effective.chapter3;

/**
 * @author hzliyong
 *
 */
public class Color {

	private int color;
	
	public Color() {
		
	}
	
	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Color)) {
			return false;
		}
		Color c = (Color) o;
		return c.equals(this);
	}
}
