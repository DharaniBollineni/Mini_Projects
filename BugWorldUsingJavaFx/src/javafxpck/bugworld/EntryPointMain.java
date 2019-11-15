package javafxpck.bugworld;






import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.TimelineBuilder;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;
import javafx.util.Duration;

public class EntryPointMain extends Application {
	/**
	* <h1>Animating the Bug World</h1>
	* Animated Bug World using JavaFx. World contains bugs and plants. where plant can grow and bugs on move inside a particular screen size.
	* <p>
	* Bug move depends on the boundaries. Plant grow depends on the collision. If there is any collision of plant while growing then plants stops its growth.
	* <p>
	* Every bug have different speed and Storing the bug objects in ArrayList "bugList". plant objects are stored in the plant ArrayList. 
	* <p>
	* kindly read the comments to understand the program. kept user friendly
	* @author  Dharani Bollineni
	* @version 1.0
	* @since   2019-08-01 
	*/

	private int width = 800, height = 600; // height and width of the Stage
	private int vBoxWidth, vBoxHeight; // for VBox
	private int xPosition; // for circle
	private int yPosition; // for circle
	private Button btnSpider; // to add Spider
	private Button btnLadyBug; // to add  LadyBug
	private Button btnButterFly; // to add  butterfly
	private Button btnPlant;    // to add plant
	private Button btnGrowPlant; // to grow plant
	private Button btnStartMove; // to move
	private Button btnStopMove; // to stop moving
	private Button btnClearAll; // clear the screen and lists
	private Button btnPlayMusic; // play and stop the music
	private List<Bug> bugList = new ArrayList<Bug>();  // stores all Bugs
	private List<Plant> plantList = new ArrayList<Plant>();// stores all plants
	private boolean flag = false, musicFlag = false;  // for buttons to stop or perform action
	private Scene scene; // scene object


	/**
	 * 
	 */
	@Override
	public void start(Stage isStage) throws Exception {
		/*
		 * <h1> start method <h1>
		 * Description: start method gets the stage parameter. 
		 * Created different panes like BroderPane(parent), VBox pane (child).
		 * created different node like buttons for adding bugs, add plants, to perform different operations like move, grow , play background music, clear,
		 * etc.
		 * add nodes to 
		 */

		// create empty pane
		BorderPane bPaneParent = new BorderPane(); // parent pane
		VBox vBoxChild = new VBox(30);//child pane with spacing between nodes(buttons)
				
		// Initialize nodes
		btnSpider = new Button();
		btnLadyBug = new Button();
		btnButterFly = new Button();
		btnPlant = new Button();
		btnGrowPlant = new Button();
		btnPlayMusic = new Button();
		btnStartMove = new Button();
		btnStopMove = new Button();
		btnClearAll = new Button();

		
		isStage.setTitle("Bug World"); // title of the stage
		setBtnProperties(); // set properties of child pane and nodes

		// add action event to the button
		btnSpider.setOnAction(new EventHandler<ActionEvent>() {
			// add spider to buglist with collision check
			@Override
			public void handle(ActionEvent arg0) {
				vBoxWidth = (int) vBoxChild.getWidth();// get the height and width of the VBox
				vBoxHeight = (int) vBoxChild.getHeight();
				float dx = -1.5f, dy = -1.5f;// for speed
				boolean createFlag = true;// collision check
				while (createFlag) {      // loop runs until true
					xPosition = getXPositionValue(vBoxWidth); //gets the coordinates 
					yPosition = getYPositionValue();
					Spider spider = new Spider(xPosition, yPosition, dx, dy); // create object
					createFlag = createBug(bPaneParent, spider, "spiderMoving.gif");
				}
			}

		});

		// add action event to the button
		btnLadyBug.setOnAction(new EventHandler<ActionEvent>() {
			// add ladyBug to buglist with collision check
			@Override
			public void handle(ActionEvent arg0) {  // same as spider creation
				vBoxWidth = (int) vBoxChild.getWidth();
				vBoxHeight = (int) vBoxChild.getHeight();
				float dx = -2.0f, dy = -2.0f;
				boolean createFlag = true;
				while (createFlag) {
					xPosition = getXPositionValue(vBoxWidth);
					yPosition = getYPositionValue();
					LadyBug lbug = new LadyBug(xPosition, yPosition, dx, dy);
					createFlag = createBug(bPaneParent, lbug, "ladyBug.gif");
				}
			}

		});
		// add action event to the button
		btnButterFly.setOnAction(new EventHandler<ActionEvent>() {
			// add ButterFly to buglist with collision check
			@Override
			public void handle(ActionEvent arg0) { // same as spider creation
				vBoxWidth = (int) vBoxChild.getWidth();
				vBoxHeight = (int) vBoxChild.getHeight();
				float dx = -2.5f, dy = -2.5f;
				boolean createFlag = true;
				while (createFlag) {
					xPosition = getXPositionValue(vBoxWidth);
					yPosition = getYPositionValue();
					ButterFly bFly = new ButterFly(xPosition, yPosition, dx, dy);
					createFlag = createBug(bPaneParent, bFly, "butterFly.gif");
				}
			}
		});
		// add action event to the button.
		btnPlant.setOnAction(new EventHandler<ActionEvent>() {
			// add plant to the plant list
			@Override
			public void handle(ActionEvent arg0) {
				vBoxWidth = (int) vBoxChild.getWidth();
				vBoxHeight = (int) vBoxChild.getHeight();
				boolean createFlag = true;
				while (createFlag) {
					xPosition = getXPositionValue(vBoxWidth);
					yPosition = getYPositionValue();
					Plant plant = new Plant(xPosition, yPosition, Color.LAWNGREEN);
					createFlag = createPlant(bPaneParent, plant, "plant.png"); // add to plant list
				}
			}

		});

		KeyFrame frame = new KeyFrame(Duration.millis(16), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (flag == false)//to stop moving
					return;

				int size = bugList.size();
				int i=0;
				while(i<size)
				{
					boolean isCollisionDetected = bugList.get(i).move(isStage, width, height, vBoxWidth, vBoxHeight, bugList);	
					if(isCollisionDetected) {
						Bug b=bugList.get(i);
						bPaneParent.getChildren().remove(b);					
						bugList.remove(b);						
						size--;						
					}
					else
						i++;
				}
			}

		});
		TimelineBuilder.create().cycleCount(javafx.animation.Animation.INDEFINITE).keyFrames(frame).build().play();

		//  Start moving bugs implementation
		btnStartMove.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				flag = true;
			}
		});

		// button stop move implementation
		btnStopMove.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				flag = false;
			}
		});
		// button Grow implementation
		btnGrowPlant.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				for (Plant p : plantList) {				
					p.growPlant(isStage, p, plantList);				
				}
			}
		});

		// to clear all objects
		btnClearAll.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				clearScreen(bPaneParent);

			}
		});
		btnPlayMusic.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				playStopMusic();
			}
		});

		// add children to root
		vBoxChild.getChildren().add(btnSpider); // add nodes to Vbox
		vBoxChild.getChildren().add(btnLadyBug);
		vBoxChild.getChildren().add(btnButterFly);
		vBoxChild.getChildren().add(btnPlant);
		vBoxChild.getChildren().add(btnGrowPlant);
		vBoxChild.getChildren().add(btnPlayMusic);
		vBoxChild.getChildren().add(btnStartMove);
		vBoxChild.getChildren().add(btnStopMove);
		vBoxChild.getChildren().add(btnClearAll);

		bPaneParent.setLeft(vBoxChild); // add Vbox child to left side of the parent broader pane
		bPaneParent.setBackground(null); // hide bPaneParent background and make scene background visible 
		scene = new Scene(bPaneParent, width, height); // create scene with root
		Image image = new Image(getClass().getResourceAsStream("background.png")); //create image object
		scene.setFill(new ImagePattern(image)); // to set background for scene

		isStage.setScene(scene); // add scene to root
		isStage.show(); // shows the stage window with above

	}

	// to play audio 
	private void playStopMusic() {
		AudioClip ac = new AudioClip(this.getClass().getResource("bensound-tenderness.mp3").toString());
		musicFlag = !musicFlag;
		if (musicFlag == false) {
			ac.stop();
		} else {
			ac.play();
		}
	}

	// to clear the screen / delete all plants and bugs
	private void clearScreen(BorderPane bPaneParent) {
		for (Bug bp : bugList) {
			bPaneParent.getChildren().remove(bp);
		}
		for (Plant bp : plantList) {
			bPaneParent.getChildren().remove(bp);
		}
		plantList.clear();
		bugList.clear();

	}

	// to get xPosition of the object as per the vbox
	private int getXPositionValue(int vBoxWidth) {
		xPosition = (int) (Math.random() * (width - 50)) + 1;
		if (xPosition < vBoxWidth) {
			xPosition = vBoxWidth +50;
			return xPosition;
		}
		return xPosition;
	}
	// to get yPosition of the object
	private int getYPositionValue() {
		yPosition = (int) (Math.random() * (height - 20)) + 1;
		return yPosition;
	}

	// create bug with collision check
	private boolean createBug(BorderPane bPaneParent, Bug bugType, String fileName) {
		boolean collisionDetected = false;
		for (Bug listElnt : bugList) {
			if (bugType.getBoundsInParent().intersects(listElnt.getBoundsInParent())) {
				collisionDetected = true;
				return collisionDetected;
			}
		}
		for (Plant listElnt : plantList) {
			if (bugType.getBoundsInParent().intersects(listElnt.getBoundsInParent())) {
				collisionDetected = true;
				return collisionDetected;
			}
		}
		if (collisionDetected == false) {
			Image image = new Image(getClass().getResourceAsStream(fileName));
			bugType.setFill(new ImagePattern(image));
			bPaneParent.getChildren().add(bugType);
			bugList.add(bugType);
		}
		return collisionDetected;

	}

	// create plant with collision check
	private boolean createPlant(BorderPane bPaneParent, Plant plantRef, String fileName) {
		boolean collisionDetected = false;
		for (Bug listElnt : bugList) {
			if (plantRef.getBoundsInParent().intersects(listElnt.getBoundsInParent())) {
				collisionDetected = true;
				return collisionDetected;
			}
		}
		for (Plant listElnt : plantList) {
			if (plantRef.getBoundsInParent().intersects(listElnt.getBoundsInParent())) {
				collisionDetected = true;
				return collisionDetected;
			}
		}
		if (collisionDetected == false) {
			Image image = new Image(getClass().getResourceAsStream(fileName));
			plantRef.setFill(new ImagePattern(image));
			bPaneParent.getChildren().add(plantRef);
			plantList.add(plantRef);
		}
		return collisionDetected;

	}

	private void setBtnProperties() {
		// set setPrefWidth of the button
		btnSpider.setPrefWidth(120);
		btnLadyBug.setPrefWidth(120);
		btnButterFly.setPrefWidth(120);
		btnPlant.setPrefWidth(120);
		btnPlayMusic.setPrefWidth(120);
		btnGrowPlant.setPrefWidth(120);
		btnStartMove.setPrefWidth(120);
		btnStopMove.setPrefWidth(120);
		btnClearAll.setPrefWidth(120);

		// set Style color
		btnSpider.setStyle("-fx-background-color: #B0E0E6; ");
		btnLadyBug.setStyle("-fx-background-color: #B0E0E6; ");
		btnButterFly.setStyle("-fx-background-color: #B0E0E6; ");
		btnPlant.setStyle("-fx-background-color: #B0E0E6; ");
		btnGrowPlant.setStyle("-fx-background-color: #B0E0E6; ");
		btnPlayMusic.setStyle("-fx-background-color: #B0E0E6; ");
		btnStopMove.setStyle("-fx-background-color: #B0E0E6; ");
		btnStartMove.setStyle("-fx-background-color: #B0E0E6; ");
		btnClearAll.setStyle("-fx-background-color: #B0E0E6; ");

		// set Text for buttons
		btnSpider.setText("Add Spider"); // button with text on it
		btnLadyBug.setText("Add LadyBug");
		btnButterFly.setText("Add ButterFly");
		btnPlant.setText("Add Plant");
		btnGrowPlant.setText("Grow Plant");
		btnPlayMusic.setText("playMusic");
		btnStartMove.setText("Make a Move");
		btnStopMove.setText("Stop Moving");
		btnClearAll.setText("Clear");
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}