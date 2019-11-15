package javafxpck.bugworld;

import java.util.Iterator;
import java.util.List;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

//bug class extends from circle
public class Bug extends Circle {

	private float dx, dy;
	private int yPosition, xPosition;
	private Color color;

	// constructor 
	public Bug(int xPosition, int yPosition, Color clr, float dx, float dy) {
		setxPosition(xPosition);
		setyPosition(yPosition);
		setColor(clr);
		setDx(dx);
		setDy(dy);
		this.setRadius(25);
	}

	// method to perform move based on boundaries
	public boolean move(Stage primaryStage, int width, int height, int vBoxWidth, int vBoxHeight, List<Bug> bugList) {
		
		if (getCenterX() + getTranslateX()  < getRadius()+vBoxWidth || getCenterX() + getTranslateX() + getRadius() > width) {
			dx = -dx;				
		}
		if (getCenterY() + getTranslateY() < getRadius() || getCenterY() + getTranslateY() + getRadius() > height) {
		    dy = -dy;
		}
		for(int i = 0; i < bugList.size(); i++) {
			Bug listElnt = bugList.get(i);
			if(this != listElnt && this.getBoundsInParent().intersects(listElnt.getBoundsInParent())) {
				return true;
			}
		}
		
		setTranslateX(getTranslateX() + dx);
		setTranslateY(getTranslateY() + dy);
		if(getTranslateX() < vBoxWidth )
		{	
			setTranslateX(vBoxWidth+5);
		}
		return false;
	}

	public float getDx() {
		return dx;
	}

	public void setDx(float dx) {
		this.dx = dx;
	}

	public float getDy() {
		return dy;
	}

	public void setDy(float dy) {
		this.dy = dy;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		setFill(color);
		this.color = color;
	}

	public void setxPosition(int xLocation) {
		this.setTranslateX(xLocation);
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yLocation) {
		this.setTranslateY(yLocation);
	}

	public int getxPosition() {
		return xPosition;
	}

}
