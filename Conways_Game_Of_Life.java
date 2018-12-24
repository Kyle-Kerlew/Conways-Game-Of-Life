package com.kyle;

/**
 * 
 * @author kyle kerlew
 * @Description Any live cell with fewer than two live neighbors dies, as if
 *              caused by under population. Any live cell with two or three live
 *              neighbors lives on to the next generation. Any live cell with
 *              more than three live neighbors dies, as if by overpopulation.
 *              Any dead cell with exactly three live neighbors becomes a live
 *              cell, as if by reproduction.
 */
public class Main {

	private static final int[][] CURRENT_GENERATION = { { 0, 0, 0, 0, 1 }, { 0, 0, 0, 1, 1 }, { 0, 0, 1, 1, 1 },
			{ 0, 1, 1, 1, 1 } }; // TODO: Randomize first generation

	public static void main(String args[]) {
		final int numOfRows = 4;
		final int numOfCols = 5;
		int[][] nextGeneration = new int[numOfRows][numOfCols]; // New generation created from the old generation
		createNextGeneration(nextGeneration, numOfRows, numOfCols);
		// TODO: Create infinite loop showing population
	}

	private static void createNextGeneration(int[][] nextGeneration, int numOfRows, int numOfCols) {
		int numOfAliveNeighbors = 0;
		for (int row = 0; row < numOfRows; row++) {
			if (row != 0) {
				System.out.println();
			}
			for (int column = 0; column < numOfCols; column++) {
				numOfAliveNeighbors = 0; // Resets the number of neighbors for each cell

				if (row <= numOfRows - 1) { // Handles all rows
					if (row == numOfRows - 1) { // Specifically handles bottom row
						if (column <= numOfCols - 1) { // handles all columns
							if (column == numOfCols - 1) { // specifically handles right-most column on the bottom row
								if (CURRENT_GENERATION[row][column - 1] == 1) { // left neighbor alive?
									numOfAliveNeighbors++;
								}
								if (CURRENT_GENERATION[row - 1][column] == 1) { // top neighbor alive?
									numOfAliveNeighbors++;
								}
								if (CURRENT_GENERATION[row - 1][column - 1] == 1) { // top left neighbor alive?
									numOfAliveNeighbors++;
								}
							} else if (column == 0) { // specifically handles the left-most column on the bottom row
								if (CURRENT_GENERATION[row][column + 1] == 1) { // left neighbor alive?
									numOfAliveNeighbors++;
								}
								if (CURRENT_GENERATION[row - 1][column] == 1) { // top neighbor alive?
									numOfAliveNeighbors++;
								}
								if (CURRENT_GENERATION[row - 1][column + 1] == 1) { // top right neighbor alive?
									numOfAliveNeighbors++;
								}
							} else if (column != 0 && column != numOfCols - 1) {
								if (CURRENT_GENERATION[row][column + 1] == 1) { // right neighbor alive?
									numOfAliveNeighbors++;
								}
								if (CURRENT_GENERATION[row][column - 1] == 1) { // left neighbor alive?
									numOfAliveNeighbors++;
								}
								if (CURRENT_GENERATION[row - 1][column] == 1) { // top neighbor alive?
									numOfAliveNeighbors++;
								}
								if (CURRENT_GENERATION[row - 1][column - 1] == 1) { // top left neighbor alive?
									numOfAliveNeighbors++;
								}
								if (CURRENT_GENERATION[row - 1][column + 1] == 1) { // top right neighbor alive?
									numOfAliveNeighbors++;
								}
							}
						}
					} else if (row == 0) { // specifically handles top row
						if (column <= numOfCols - 1) { // handles all columns in the top row
							if (column == numOfCols - 1) { // specifically handles right-most column on the top row
								if (CURRENT_GENERATION[row][column - 1] == 1) { // left neighbor alive?
									numOfAliveNeighbors++;
								}
								if (CURRENT_GENERATION[row + 1][column] == 1) { // bottom neighbor alive?
									numOfAliveNeighbors++;
								}
								if (CURRENT_GENERATION[row + 1][column - 1] == 1) { // Bottom left neighbor alive?
									numOfAliveNeighbors++;
								}
							} else if (column == 0) { // specifically handles left-most column on the top row
								if (CURRENT_GENERATION[row][column + 1] == 1) { // right neighbor alive?
									numOfAliveNeighbors++;
								}
								if (CURRENT_GENERATION[row + 1][column] == 1) { // bottom neighbor alive?
									numOfAliveNeighbors++;
								}
								if (CURRENT_GENERATION[row + 1][column + 1] == 1) { // bottom right alive?
									numOfAliveNeighbors++;
								}
							} else { // All columns between left-most and right-most on the top row
								if (CURRENT_GENERATION[row][column + 1] == 1) { // right neighbor alive?
									numOfAliveNeighbors++;
								}
								if (CURRENT_GENERATION[row][column - 1] == 1) { // left neighbor alive?
									numOfAliveNeighbors++;
								}
								if (CURRENT_GENERATION[row + 1][column] == 1) { // bottom neighbor alive?
									numOfAliveNeighbors++;
								}
								if (CURRENT_GENERATION[row + 1][column - 1] == 1) { // bottom left neighbor alive?
									numOfAliveNeighbors++;
								}
								if (CURRENT_GENERATION[row + 1][column + 1] == 1) { // bottom right neighbor alive?
									numOfAliveNeighbors++;
								}
							}
						}
					} else if (row != 0 && row != numOfRows - 1) { // Handles all rows other than top and bottom rows
						if (column <= numOfCols - 1) { // handles all columns in all non-boundary rows
							if (column == numOfCols - 1) { // specifically handles right-most column on the all non
								if (CURRENT_GENERATION[row][column - 1] == 1) { // left neighbor alive?
									numOfAliveNeighbors++;
								}
								if (CURRENT_GENERATION[row + 1][column] == 1) { // bottom neighbor alive?
									numOfAliveNeighbors++;
								}
								if (CURRENT_GENERATION[row - 1][column] == 1) { // top neighbor alive?
									numOfAliveNeighbors++;
								}
								if (CURRENT_GENERATION[row + 1][column - 1] == 1) { // bottom left neighbor alive?
									numOfAliveNeighbors++;
								}
								if (CURRENT_GENERATION[row - 1][column - 1] == 1) { // top left neighbor alive?
									numOfAliveNeighbors++;
								}

							} else if (column == 0) { // specifically handles left-most column in all non-boundary rows
								if (CURRENT_GENERATION[row][column + 1] == 1) { // right neighbor alive?
									numOfAliveNeighbors++;
								}
								if (CURRENT_GENERATION[row + 1][column] == 1) { // bottom neighbor alive?
									numOfAliveNeighbors++;
								}
								if (CURRENT_GENERATION[row - 1][column] == 1) { // top neighbor alive?
									numOfAliveNeighbors++;
								}
								if (CURRENT_GENERATION[row + 1][column + 1] == 1) { // bottom right alive?
									numOfAliveNeighbors++;
								}
								if (CURRENT_GENERATION[row - 1][column + 1] == 1) { // top right alive?
									numOfAliveNeighbors++;
								}
							} else if (column != 0 && column != numOfCols - 1) { // Handles all non-boundary columns in
																					// all non-boundary rows
								if (CURRENT_GENERATION[row][column + 1] == 1) { // right neighbor alive?
									numOfAliveNeighbors++;
								}
								if (CURRENT_GENERATION[row][column - 1] == 1) { // left neighbor alive?
									numOfAliveNeighbors++;
								}
								if (CURRENT_GENERATION[row + 1][column] == 1) { // bottom neighbor alive?
									numOfAliveNeighbors++;
								}
								if (CURRENT_GENERATION[row - 1][column] == 1) { // top neighbor alive?
									numOfAliveNeighbors++;
								}
								if (CURRENT_GENERATION[row + 1][column - 1] == 1) { // bottom left neighbor alive?
									numOfAliveNeighbors++;
								}
								if (CURRENT_GENERATION[row - 1][column - 1] == 1) { // top left neighbor alive?
									numOfAliveNeighbors++;
								}
								if (CURRENT_GENERATION[row + 1][column + 1] == 1) { // bottom right neighbor alive?
									numOfAliveNeighbors++;
								}
								if (CURRENT_GENERATION[row - 1][column + 1] == 1) { // top right neighbor alive?
									numOfAliveNeighbors++;
								}
							}
						}
					}
				}

				/*
				 * Determines whether or not cell should be alive based on rules of Conway's
				 * Game of Life
				 */
				if (CURRENT_GENERATION[row][column] == 1) {
					if (numOfAliveNeighbors < 2) {
						nextGeneration[row][column] = 0; // cell dies with fewer than 2 alive neighbors
					} else if (numOfAliveNeighbors == 2 || numOfAliveNeighbors == 3) {
						// Nothing happens to cell
					} else if (numOfAliveNeighbors > 3) {
						nextGeneration[row][column] = 0; // cell dies with more than 3 alive neighbors
					}
				} else if (CURRENT_GENERATION[row][column] == 0) {
					if (numOfAliveNeighbors == 3) {
						nextGeneration[row][column] = 1; // Cell becomes alive because it has 3 neighbors
					}
				}
				displayGeneration(nextGeneration[row][column]);
			}
		}
	}

	private static void displayGeneration(int cell) {
		if (cell == 0) {
			System.out.print(".");
		} else if (cell == 1) {
			System.out.print("*");
		}
	}
	
	/**
	 * TODO: Create method that checks boundaries with repeting cell checking to make more readable code.
	 */
}