package br.com.etyllica.ipfun.model;

import java.awt.Color;

import br.com.etyllica.core.graphics.SVGColor;

public enum FunnyColor {

	YELLOW(SVGColor.YELLOW, 0),
	ORANGE(SVGColor.ORANGE, 1),
	BLUE(SVGColor.BLUE, 2),
	DARK_BLUE(SVGColor.DARK_BLUE, 3),
	RED(SVGColor.RED, 4),
	BROWN(SVGColor.BROWN, 5),
	PURPLE(SVGColor.PURPLE, 6),
	VIOLET(SVGColor.VIOLET, 7),
	GREEN(SVGColor.GREEN, 8),
	SEA_GREEN(SVGColor.SEA_GREEN, 9),
	SKY_BLUE(SVGColor.SKY_BLUE, 10),
	LIME_GREEN(SVGColor.LIME_GREEN, 11),
	LIGHT_GRAY(SVGColor.LIGHT_GRAY, 12),
	GRAY(SVGColor.GRAY, 13),
	WHITE(SVGColor.WHITE, 14),
	BLACK(SVGColor.BLACK, 15);
	
	private FunnyColor(Color color, int value) {
		this.color = color;
		this.value = value;
	}

	private final int value;
	
	private final Color color;

	public int getValue() {
		return value;
	}

	public Color getColor() {
		return color;
	}
		
}
