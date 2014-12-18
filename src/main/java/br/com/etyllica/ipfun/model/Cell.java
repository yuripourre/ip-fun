package br.com.etyllica.ipfun.model;

import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.gui.factory.DefaultButton;
import br.com.etyllica.gui.label.ImageLabel;


public class Cell extends DefaultButton {

	private Animal animal;
	
	private FunnyColor color;

	public Cell(int x, int y, int w, int h) {
		super(x,y,w,h);
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
		
		String path = animal.toString().toLowerCase()+".png";
		
		this.setLabel(new ImageLabel(path));
	}

	public FunnyColor getColor() {
		return color;
	}
	
	public int getValue() {
		return animal.getValue()+color.getValue()*16;
	}

	public void setColor(FunnyColor color) {
		this.color = color;
	}
	
	@Override
	public void drawLabel(Graphic g) {
		
		g.setColor(color.getColor());
		g.fillOval(this);
		
		super.drawLabel(g);
	}
	
}
