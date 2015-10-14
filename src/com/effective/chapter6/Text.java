package com.effective.chapter6;

import java.util.EnumSet;
import java.util.Set;

public class Text {

	private static final int STYLE_BOLD = 1 << 0;
	private static final int STYLE_ITALIC = 1 << 1;
	private static final int STYLE_UNDERLINE = 1 << 2;
	private static final int STYLE_STRIKETHROUGH = 1 << 3;

	public void applyStyles(int styles) {

	}

	public enum Style {
		BOLD, ITALIC, UNDERLINE, STRIKETHROUGH;
	}

	public void applyStyle(Set<Style> styles) {

	}

	public static void main(String[] args) {
		Text text = new Text();
		text.applyStyle(EnumSet.of(Style.BOLD, Style.ITALIC));
	}
}
