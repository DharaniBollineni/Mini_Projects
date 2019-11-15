package gol2d.basicImplementaion;
import java.util.Random;

public class GameOfLife {

	// this is for fixed size and randam values
	// but need some changes for infinit with scale and selection of x and y
	// exchange current array and swap next generation method
	// connectivity with javafx

	private int height = 12;
	private int width = 12;
	Point[][] grid = new Point[height][width]; // empty 2d array

	public GameOfLife() {
		fillArrayWithRandam();
		for (int i = 0; i < 20; i++) {
			playGame();
		}
	}

	// fill array with randam number 0 or 1
	private void fillArrayWithRandam() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				// System.out.println("test1 "+i);
				Random r = new Random();
				boolean ranValue = r.nextBoolean();
				grid[i][j] = new Point(i, j);
				if (ranValue == true) {
					grid[i][j].setValue(1);
				} else {
					grid[i][j].setValue(0);
				}

			}
		}
	}

	private void printArray() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(grid[i][j].getValue() + " ");
			}
			System.out.println();
		}
		System.out.println("----------------------------------------");

	}

	private int countNeighbors(int x, int y) {
		int sum = 0;
		// sum +=grid[x-1][y-1].getValue();
		// sum +=grid[x][y-1].getValue();
		// sum +=grid[x+1][y-1].getValue();
		// sum +=grid[x+1][y].getValue();
		// sum +=grid[x+1][y+1].getValue();
		// sum +=grid[x][y+1].getValue();
		// sum +=grid[x-1][y+1].getValue();
		// sum +=grid[x-1][y].getValue();

		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {

				int col = (x + i + height) % height; // colums
				int row = (y + j + width) % width; // rows
				sum += grid[col][row].getValue();

			}

		}
		sum -= grid[x][y].getValue();
		return sum;
	}

	private void playGame() {
		Point[][] next = new Point[height][width]; // empty 2d array
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int val = grid[i][j].getValue();
				// count the live neighbors
				int noofNeigbors = countNeighbors(i, j);
				next[i][j] = new Point(i, j);
				if (val == 1 && noofNeigbors < 2)// rule1
				{ next[i][j].setValue(0);
				} else if (val == 1 && noofNeigbors > 3) {
					next[i][j].setValue(0);
				} else if (val == 0 && noofNeigbors == 3) {
					next[i][j].setValue(1);
				} else if ((noofNeigbors == 2 || noofNeigbors == 3) && val == 1) {
					next[i][j].setValue(1);
				} else {
					next[i][j].setValue(0);
				}

			}
		}
		grid = next;
		printArray();

	}

	public static void main(String[] args) {
		{
			new GameOfLife();
		}
	}

}
