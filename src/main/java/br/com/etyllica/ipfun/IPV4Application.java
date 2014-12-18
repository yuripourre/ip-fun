package br.com.etyllica.ipfun;

import java.util.ArrayList;
import java.util.List;

import br.com.etyllica.context.Application;
import br.com.etyllica.core.event.Action;
import br.com.etyllica.core.event.GUIEvent;
import br.com.etyllica.core.graphics.Graphic;
import br.com.etyllica.gui.factory.DefaultButton;
import br.com.etyllica.gui.label.ColorLabel;
import br.com.etyllica.gui.label.ImageLabel;
import br.com.etyllica.ipfun.model.Animal;
import br.com.etyllica.ipfun.model.Cell;
import br.com.etyllica.ipfun.model.FunnyColor;

public class IPV4Application extends Application {

	private int currentCell = 0;
	
	private List<Cell> cells = new ArrayList<Cell>();
		
	private String generatedIp = "0.0.0.0";
	
	public IPV4Application(int w, int h) {
		super(w, h);
	}

	@Override
	public void load() {
		createAnimalButtons();
		createColorButtons();
		createCells();
	}
	
	private void createCells() {
		for(int i = 0; i < 4; i++) {
			Cell cell = new Cell(200+130*(i%4), 42, 128, 128);
			cell.setAnimal(Animal.ELEPHANT);
			cell.setColor(FunnyColor.YELLOW);
			
			Action action = new Action(this, "changeCurrentCell", i);
			cell.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, action);
			
			cells.add(cell);
			add(cell);
		}
	}
			
	private void createAnimalButtons() {
		
		int extraOffset = 4;
		
		int i = 0;
		
		for(Animal animal: Animal.values()) {
						
			DefaultButton button = new DefaultButton(20+130*(i%4), extraOffset+180+130*(i/4), 128, 128);
			
			Action mouseAction = new Action(this, "changeAnimal", animal);
			button.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, mouseAction);
			add(button);
		
			ImageLabel animalLabel = new ImageLabel(animal.toString().toLowerCase()+".png");
			button.setLabel(animalLabel);
			
			i++;
		}
	}
	
	private void createColorButtons() {
		
		int i = 0;
		
		for(FunnyColor color: FunnyColor.values()) {
			
			DefaultButton button = new DefaultButton(600+66*(i%2), 180+66*((i*4)/8), 64, 64);
			
			Action mouseAction = new Action(this, "changeColor", color);
			button.addAction(GUIEvent.MOUSE_LEFT_BUTTON_UP, mouseAction);
			add(button);
		
			ColorLabel colorLabel = new ColorLabel(color.getColor(), 48, 48);
			button.setLabel(colorLabel);
			
			i++;
		}
		
	}	
	
	public void changeAnimal(Animal animal) {
		cells.get(currentCell).setAnimal(animal);
		recalculateIp();
	}
	
	public void changeColor(FunnyColor color) {
		cells.get(currentCell).setColor(color);
		recalculateIp();
	}
	
	public void changeCurrentCell(int index) {
		currentCell = index;
	}
	
	private void recalculateIp() {
		
		StringBuilder builder = new StringBuilder();
						
		builder.append(Integer.toString(cells.get(0).getValue()));
		builder.append(".");
		builder.append(Integer.toString(cells.get(1).getValue()));
		builder.append(".");
		builder.append(Integer.toString(cells.get(2).getValue()));
		builder.append(".");
		builder.append(Integer.toString(cells.get(3).getValue()));
		
		generatedIp = builder.toString();
	}
	
	@Override
	public void draw(Graphic g) {
		g.setFontSize(30);
		g.drawStringBorderX(generatedIp, 750);
	}

}
