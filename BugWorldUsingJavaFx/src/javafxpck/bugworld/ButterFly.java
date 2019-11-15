package javafxpck.bugworld;

import javafx.scene.paint.Color;
//ButterFly class is child class of bug class
public class ButterFly extends Bug {

	public ButterFly(int xPosition, int yPosition,float dx,float dy) {		
		
		super(xPosition, yPosition, Color.RED,dx,dy);

	}

}