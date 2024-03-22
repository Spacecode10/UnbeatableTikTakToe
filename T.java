package lab;

import java.util.*;

public class T {
	public int k = 0;

	static class Move {
		int i, j;
	};

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
	}

	static char player = 'x', opponent = 'o';

	static Boolean isMovesLeft(char board[][]) {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (board[i][j] == '\0')
					return true;
		return false;
	}

	static int eval(char[][] grid) {

		// for checking row
		for (int i = 0; i < 3; i++) {
			if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
				if (grid[i][0] == player) {
					return +10;
				} else if (grid[i][0] == opponent) {
					return -10;
				}
			}
		}
		// for checking columns
		for (int i = 0; i < 3; i++) {
			if (grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i]) {
				if (grid[0][i] == player) {
					return +10;
				} else if (grid[0][i] == opponent) {
					return -10;
				}
			}
		}

		// for checking diagonals
		if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
			if (grid[0][0] == player) {
				return 10;
			} else if (grid[0][0] == opponent) {
				return -10;
			}
		}
		if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
			if (grid[0][2] == player) {
				return 10;
			} else if (grid[0][2] == opponent) {
				return -10;
			}
		}
		return 0;
	}

	static int minimax(int depth, char[][] grid, boolean isMax,int alpha,int beta) {

		int value = eval(grid);
		if (value == 10) {
			return 10;
		}
		if (value == -10) {
			return -10;

		}
		if (isMovesLeft(grid) == false)
			return 0;
		if (isMax) {
			int best = -1000;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					// Check if cell is empty
					if (grid[i][j] == '\0') {
						// Make the move
						grid[i][j] = player;
						best = Math.max(minimax(depth + 1, grid, !isMax,alpha,beta), best);
						 best = Math.max(best, value);
				            alpha = Math.max(alpha, best);
						grid[i][j] = '\0';
						
					}
				}
			}
			return best;
		} else {
			int best = 1000;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					// Check if cell is empty
					if (grid[i][j] == '\0') {
						// Make the move
						grid[i][j] = 'o';
						best = Math.min(minimax(depth + 1, grid, !isMax,alpha,beta), best);
						grid[i][j] = '\0';
						 					}
				}
			}
			return best;
		}
	}

	void display(char[][] grid) {
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

	static Move AIMove(char[][] grid) {
		int best = -1000;
		Move ob = new Move();
		ob.i = -1;
		ob.j = -1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				// Check if cell is empty
				if (grid[i][j] == '\0') {
					// Make the move
					grid[i][j] = player;
					int value = minimax(0, grid, false,10,-10);
					grid[i][j] = '\0';
					if (value > best) {
						ob.i = i;
						ob.j = j;
						best = value;
					}
				}
			}
		}
		return ob;
	}

	public static void main(String[] args) {
		T ob1 = new T();
		Scanner sc = new Scanner(System.in);
		char[][] grid = new char[3][3];
		boolean finished = false;
		for (ob1.k = 0; ob1.k < 10 && !finished; ob1.k++) {
			int input = 0;
			if (ob1.k < 9 && ob1.k % 2 == 0) {
				System.out.println("\nai move");
				Move ob = AIMove(grid);
				input = ob.i * 3 + ob.j +1;

			} else if (ob1.k < 9 && ob1.k % 2 != 0) {
				System.out.println("\nenter the square the player wants to put sign x");
				input = sc.nextInt();
			}
			ob1.grid(grid, input, ob1.k);
			ob1.display(grid);
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
			// checking if any winner appeared on columns
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
			// checking if any winner appeared on diagonals
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
