package gameOfLife.population;

import java.util.Random;

public class Population {

	private int aliveCount;
	private int deadCount;

	public Population(int rows, int columns) { // Creates a population in terms of rows and columns
		int[][] currentGeneration = new int[rows][columns];
		int[][] nextGeneration = new int[rows][columns];
		currentGeneration = setPopulation(currentGeneration, rows, columns);

		do {
			try {
				displayGeneration(currentGeneration);
				countDeadAlive(currentGeneration);
				System.out.printf("\nAlive: %d. Dead: %d.\n", getAliveCount(), getDeadCount());
				
				nextGeneration = createNextGeneration(currentGeneration, nextGeneration, rows, columns);
				displayGeneration(nextGeneration);
				currentGeneration = nextGeneration;
				countDeadAlive(nextGeneration);
				System.out.printf("\nAlive: %d. Dead: %d.\n", getAliveCount(), getDeadCount());
		
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (true);
	}

	
	public Population(Random r) { 
		this(r.nextInt(100) + 1, r.nextInt(100) + 1);
	}

	private void countDeadAlive(int[][] generation) {
		aliveCount = 0;
		deadCount = 0;
		for (int i = 0; i < generation.length; i++) {
			for (int j = 0; j < generation[i].length; j++) {
				if (generation[i][j] == 1) {
					aliveCount++;
				} else {
					deadCount++;
				}
			}
		}
	}

	/*
	 * Returns the amount of alive cells in each generation
	 */
	private int getAliveCount() {
		return aliveCount;
	}


	/*
	 * Returns the amount of dead cells in each generation
	 */
	private int getDeadCount() {
		return deadCount;
	}

	private int[][] setPopulation(int currentGeneration[][], int rows, int columns) {
		Random r = new Random();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				currentGeneration[i][j] = r.nextInt(2); // Value 0 - 1
			}
		}
		return currentGeneration;
	}

	private int[][] createNextGeneration(int currentGeneration[][], int[][] nextGeneration, int numOfRows,
			int numOfCols) {
		int numOfAliveNeighbors = 0;
		for (int row = 0; row < numOfRows; row++) {
			for (int column = 0; column < numOfCols; column++) {
				numOfAliveNeighbors = 0; // Resets the number of neighbors for each cell
				/*
				 * Bottom-right/bottom-left/bottom neighbor checking
				 */
				if (row < numOfRows - 1) { // room to move down
					if (column < numOfCols - 1) { // room to move right
						if (currentGeneration[row + 1][column + 1] == 1) { // bottom right neighbor alive?
							numOfAliveNeighbors++;
						}
					}
					if (column > 0) { // Only room to move left
						if (currentGeneration[row + 1][column - 1] == 1) { // bottom left neighbor alive?
							numOfAliveNeighbors++;
						}
					}
					if (currentGeneration[row + 1][column] == 1) { // bottom neighbor alive?
						numOfAliveNeighbors++;
					}
				}

				/*
				 * Top-right/top-left/top neighbor checking
				 */
				if (row > 0) { // room to move up
					if (column < numOfCols - 1) { // room to move right
						if (currentGeneration[row - 1][column + 1] == 1) { // top right neighbor alive?
							numOfAliveNeighbors++;
						}
					}
					if (column > 0) {// Only room to move left
						if (currentGeneration[row - 1][column - 1] == 1) { // top left neighbor alive?
							numOfAliveNeighbors++;
						}
					}
					if (currentGeneration[row - 1][column] == 1) { // top neighbor alive?
						numOfAliveNeighbors++;
					}
				}

				/*
				 * Left-side neighbor checking
				 */
				if (column > 0) { // Room to move left?
					if (currentGeneration[row][column - 1] == 1) { // left neighbor alive?
						numOfAliveNeighbors++;
					}
				}

				/*
				 * Right-side neighbor checking
				 */
				if (column < numOfCols - 1) { // room to move right?
					if (currentGeneration[row][column + 1] == 1) { // right neighbor alive?
						numOfAliveNeighbors++;
					}
				}

				/*
				 * Determines whether or not cell should be alive based on rules of Conway's
				 * Game of Life
				 */
				if (currentGeneration[row][column] == 1) {
					if (numOfAliveNeighbors < 2) {
						nextGeneration[row][column] = 0; // cell dies with fewer than 2 alive neighbors
					} else if (numOfAliveNeighbors == 2 || numOfAliveNeighbors == 3) {
						// Nothing happens to cell
					} else if (numOfAliveNeighbors > 3) {
						nextGeneration[row][column] = 0; // cell dies with more than 3 alive neighbors
					}
				} else if (currentGeneration[row][column] == 0) {
					if (numOfAliveNeighbors == 3) {
						nextGeneration[row][column] = 1; // Cell becomes alive because it has 3 neighbors
					}
				}
			}
		}
		return nextGeneration;
	}

	/*
	 * Displays the generation in the form of dead and alive cells using . and *
	 */
	private void displayGeneration(int[][] generation) {
		for (int i = 0; i < generation.length; i++) {
			if (i != 0)
				System.out.println();
			for (int j = 0; j < generation[i].length; j++) {
				String s = (generation[i][j] == 0) ? "." : "*";
				System.out.print(s);
			}
		}
	}
}
