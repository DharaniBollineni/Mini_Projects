package javafxpck.bugworld;

import java.util.List;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
// plant class 
public class Plant extends Circle {
	private int yPosition, xPosition;
	private Color color;

	// constructor
	public Plant(int xPosition, int yPosition, Color clr) {
		setxPosition(xPosition);
		setyPosition(yPosition);
		setColor(clr);
		this.setRadius(10);
	}

	// grow plant based on collision.
	public void growPlant(Stage isStage, Plant plant, List<Plant> plantList) {
		boolean collisionDetected = false;
		if (plant.getScaleX() < 2 && plant.getScaleY() < 2) {
			for (Plant listElnt : plantList) {
				if (plant != listElnt && plant.getBoundsInParent().intersects(listElnt.getBoundsInParent())) { // same plant is in list
					collisionDetected = true;
					break;
				}
			}
			if (collisionDetected == false) {
				plant.setScaleX(plant.getScaleX() + 0.1);
				plant.setScaleY(plant.getScaleY() + 0.1);
			}
		}
	}

	// getters and setters
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		setFill(color);
		this.color = color;
	}

	public void setxPosition(int xLocation) {
		this.setCenterX(xLocation);
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yLocation) {

		this.setCenterY(yLocation);
	}

	public int getxPosition() {
		return xPosition;
	}
	

}
