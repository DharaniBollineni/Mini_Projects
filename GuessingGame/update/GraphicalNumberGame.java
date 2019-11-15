package javafxnew.update;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// final
public class GraphicalNumberGame extends Application {

	// variable declaration
	private int computerGuess; // holds integer casted random value
	private int tries=0;       // holds no of tries 
	private Text txtStatus; // holds the status details
	private TextField guessField; // textStatus field to get input
	private Button validateBtn; // button to validate
	private Label lblTitle; // label for title
	private TextArea logArea; // Create the TextArea for the Output
	private BorderPane root; // Create root node
	private BorderPane bPane; // child 1
	private VBox vPane; // child 2
	private Scene scene; // for scene

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage theStage) throws Exception {

		// title of the page
		theStage.setTitle("Start A Game");

		// Create an empty BorderPane, VBox.
		root = new BorderPane(); // root
		root.setPadding(new Insets(2,2,2,2));
		bPane = new BorderPane(); // child1		
		vPane = new VBox(); // child2
		

		// Initialize nodes
		txtStatus = new Text("Guess a Number");
		guessField = new TextField("Enter your guess");
		validateBtn = new Button("Validate");
		lblTitle = new Label("Number Guessing Game");
		logArea = new TextArea(); // Create the TextArea for the Output

		// set properties
		vBoxProrpertie();
		setTxtProperties();
		setLabelProperties();

		// add action event to the button
		validateBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				startPlay(theStage);
			}
		});

		// Add the children to the nodes.
		vPane.getChildren().add(txtStatus);
		vPane.getChildren().add(guessField);
		vPane.getChildren().add(validateBtn);

		// assign to the boarder pane
		root.setTop(bPane);
		root.setCenter(vPane);
		root.setBottom(logArea);		
		root.layoutBoundsProperty();

		// Create and assign root to scene
		scene = new Scene(root, 500, 300); // create scene with root
		theStage.setScene(scene); // add scene to root
		theStage.show(); // shows the stage window with above

		startNewGame();
	}

	// set vBox properties
	private void vBoxProrpertie() {
		vPane.setAlignment(Pos.CENTER);
		vPane.setPadding(new Insets(1,1,1,1));
		vPane.setSpacing(10);
		vPane.setStyle("-fx-background-color: #0EB7A9");
	}

	// set text properties
	private void setTxtProperties() {
		txtStatus.prefHeight(100);
		txtStatus.setStyle("-fx-font-size: 20px;");
	}

	// set label properties
	private void setLabelProperties() {
		bPane.setTop(lblTitle); // set label to borderPane child 1.
		lblTitle.setPrefHeight(10); // set the height of the label to be in.
		lblTitle.prefWidthProperty().bind(bPane.widthProperty()); // bind to the size of borderPane width
		lblTitle.setStyle("-fx-font-size: 20px;"); // set font size
		lblTitle.setAlignment(Pos.BASELINE_CENTER); // Set the alignment
		lblTitle.setPadding(new Insets(5, 5, 5, 5)); // set padding with outer border
	}

	// start a game
	private void startNewGame() {
		computerGuess = (int) (Math.random() * 10 + 1);
	}

	// logic to validate the guess
	private void startPlay(Stage theStage) {
		String input = guessField.getText();
		tries++;
		int playerGuess;
		if (isPositiveInteger(input)) {
			playerGuess = Integer.parseInt(input);
			System.out.println(computerGuess + " " + playerGuess);
			if (playerGuess == computerGuess) {
				guessSuccessful(tries);
				tries = 0;
				theStage.setTitle("New Game");
			} else if (computerGuess > playerGuess) {				
				txtStatus.setText("It's too low Enter little big value");
				guessField.setText("Enter your guess");
				writeOutputLogs("your guess is smaller then computer guess data please enter bigger value");
			} else {
				txtStatus.setText("It's too heigh-Enter smaller value");
				guessField.setText("Enter your guess");
				writeOutputLogs("your guess is greater then computer guess data please enter smaller value");
			}
		} else {
			guessField.setText("Enter your guess");
			writeOutputLogs("Given data is not an +ve integer");
		}

		guessField.requestFocus();

	}

	// method to support when the guess is successful.
	private void guessSuccessful(int tries) {
		String successMsg="You Win!!! with "+tries+" tries";
		txtStatus.setText(successMsg);
		startNewGame();
		guessField.setText("New Game - Enter guess");
		successMsg="Congratulations you won the game with "+tries+" tries.. Restarted the game again";
		writeOutputLogs(successMsg);
	}

	// method to check whether given input is an positive integer or not
	private boolean isPositiveInteger(String input) {
		try {
			Integer.parseInt(input);
			if (Integer.parseInt(input) < 0) {
				txtStatus.setText("Please enter +ve integer");
				return false;
			}
			return true;
		} catch (Exception e) {
			txtStatus.setText("Worng input please enter integer value");
			return false;
		}
	}

	// prints the messages to the Output-Area
	private void writeOutputLogs(String msg) {
		this.logArea.appendText("Your Input: " + msg + "\n");
	}

}
