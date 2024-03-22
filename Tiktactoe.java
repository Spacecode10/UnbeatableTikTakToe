package lab;

import java.util.Scanner;

public class Tiktactoe {
	public int k = 0;

	public void grid(char grid[][], int input, int flag) {
		if (flag == 9) {
			System.out.println("\nDraw\n");

		} else {
			char inp;
			if (flag % 2 == 0) {
				inp = 'x';
			} else {
				inp = 'o';
			}
			switch (input) {
			case 1:
				if (grid[0][0] != '\0') {
					System.out.println("already exist in that place enter valid input");
					k--;
					break;
				} else {
					grid[0][0] = inp;
					break;
				}
			case 2:
				if (grid[0][1] != '\0') {
					System.out.println("already exist in that place enter valid input");
					k--;
					break;
				} else {
					grid[0][1] = inp;
					break;
				}
			case 3:
				if (grid[0][2] != '\0') {
					System.out.println("already exist in that place enter valid input");
					k--;
					break;
				} else {
					grid[0][2] = inp;
					break;
				}
			case 4:
				if (grid[1][0] != '\0') {
					System.out.println("already exist in that place enter valid input");
					k--;
					break;
				} else {
					grid[1][0] = inp;
					break;
				}
			case 5:
				if (grid[1][1] != '\0') {
					System.out.println("already exist in that place enter valid input");
					k--;
					break;
				} else {
					grid[1][1] = inp;
					break;
				}
			case 6:
				if (grid[1][2] != '\0') {
					System.out.println("already exist in that place enter valid input");
					k--;
					break;
				} else {
					grid[1][2] = inp;
					break;
				}
			case 7:
				if (grid[2][0] != '\0') {
					System.out.println("already exist in that place enter valid input");
					k--;
					break;
				} else {
					grid[2][0] = inp;
					break;
				}
			case 8:
				if (grid[2][1] != '\0') {
					System.out.println("already exist in that place enter valid input");
					k--;
					break;
				} else {
					grid[2][1] = inp;
					break;
				}
			case 9:
				if (grid[2][2] != '\0') {
					System.out.println("already exist in that place enter valid input");
					k--;
					break;
				} else {
					grid[2][2] = inp;
					break;
				}
			default:
				System.out.println("invalid input");
			}
		}
		System.out.println("here's your input");
		System.out.print(" " + grid[0][0] + " |");
		System.out.print(" " + grid[0][1] + " | " + grid[0][2]);
		System.out.print("\n-- ");
		System.out.print("-- ");
		System.out.print("-- ");
		System.out.print("-- ");
		System.out.print("\n " + grid[1][0] + " |");
		System.out.print(" " + grid[1][1] + " | " + grid[1][2]);
		System.out.print("\n-- ");
		System.out.print("-- ");
		System.out.print("-- ");
		System.out.print("-- ");
		System.out.print("\n " + grid[2][0] + " |");
		System.out.print(" " + grid[2][1] + " | " + grid[2][2]);
	}

	public static void main(String[] args) {
		Tiktactoe ob1 = new Tiktactoe();
		Scanner sc = new Scanner(System.in);
		char[][] grid = new char[3][3];
		boolean finished = false;
		for (ob1.k = 0; ob1.k < 10 && !finished; ob1.k++) {
			int input = 0;
			if (ob1.k < 9) {
				System.out.println("\nenter the square next player wants to put sign");
				input = sc.nextInt();
			} else {
				input = 10000;
			}
			ob1.grid(grid, input, ob1.k);
			//checking if any winner appeared on rows
			for (int i = 0; i < 3; i++) {
				if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
					if (grid[i][0] == 'x' && grid[i][0] != '\0') {
						System.out.println("player x is winner");
						finished = true;
						break;
					} else if (grid[i][0] == 'o' && grid[i][0] != '\0') {
						System.out.println("player 0 is winner");
						finished = true;
						break;
					}
				}

			}
			//checking if any winner appeared on columns
			for (int i = 0; i < 3; i++) {
				if (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]) {
					if (grid[0][i] == 'x' && grid[0][i] != '\0') {
						System.out.println("player x is winner");
						finished = true;
						break;
					} else if (grid[0][i] == 'o' && grid[0][i] != '\0') {
						System.out.println("player 0 is winner");
						finished = true;
						break;
					}
				}
			}
			//checking if any winner appeared on diagonals
			if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
				if (grid[0][0] == 'x' && grid[0][0] != '\0') {
					System.out.println("player x is winner3");
					finished = true;
					break;
				} else if (grid[0][0] == 'o' && grid[0][0] != '\0') {
					System.out.println("player 0 is winner");
					finished = true;
					break;
				}
			}
			if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
				if (grid[0][2] == 'x' && grid[0][2] != '\0') {
					System.out.println("player x is winner4");
					break;
				} else if (grid[0][2] == 'o' && grid[0][2] != '\0') {
					System.out.println("player 0 is winner");
					break;
				}
			}
		}
	}

}
