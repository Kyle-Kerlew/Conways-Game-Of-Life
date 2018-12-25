package gameOfLife.initialize;

import java.util.Scanner;

import gameOfLife.population.Population;

/**
 * 
 * @author kyle kerlew
 * @Description 1. Any live cell with fewer than two live neighbors dies, as if
 *              caused by under population.
 *              2. Any live cell with two or three live neighbors lives on to the next generation.
 *              3. Any live cell with more than three live neighbors dies, as if by overpopulation.
 *              4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 */
public class Main {

	public static void main(String args[]) {
		System.out.println(
				"Welcome to Conways Game of Life. Select an option\n"
				+ "1. Randomize the size of the population? \n"
				+ "2. Specify size of population?");
		
		Scanner sc = new Scanner(System.in);
		
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			new Population();
			break;
		case 2:
			System.out.println("Enter the number of cells you want in each row.");
			int col = sc.nextInt();
			System.out.println("Enter the number of rows you want.");
			int row = sc.nextInt();
			new Population(row, col);
			sc.close();
			break;
		default:
			System.out.println("Invalid.");
			break;
		}
	}
}