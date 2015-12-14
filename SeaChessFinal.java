import java.util.Scanner;

public class SeaChessFinal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[][] matrix = new String[3][3];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = " ";
			}
		}

		System.out.println("The game is starting");
		System.out.println("Player 1 plays with 'O'");
		System.out.println("Player 2 plays with 'X'");

		printMatrix(matrix);
		int row = 0;
		int col = 0;
		String[] arr = new String[2];
		// int[] intArr = new int[2];
		int moves = 0;
		String playerSign = "";

		while (true) {

			System.out.println("Player 1's turn! Select coordinates!(ex: 1,1)");
			arr = sc.nextLine().split("\\s*,\\s*");
			row = Integer.parseInt(arr[0]);
			col = Integer.parseInt(arr[1]);

			playerSign = "X";
			isValid(row, col, arr, matrix, playerSign);

			printMatrix(matrix);

			if (isWinner(matrix)) {
				System.out.println("Player 1 wins the game!");
				break;
			}
			moves++;

			if (moves == 9) {
				System.out.println("No winners in the game!");
				break;
			}

			System.out.println("Player 2's turn! Select coordinates!(ex: 1,1)");
			arr = sc.nextLine().split("\\s*,\\s*");
			row = Integer.parseInt(arr[0]);
			col = Integer.parseInt(arr[1]);

			playerSign = "O";
			isValid(row, col, arr, matrix, playerSign);

			printMatrix(matrix);

			if (isWinner(matrix)) {
				System.out.println("Player 2 wins the game!");
				break;
			}
			moves++;
		}

		String answer = "";
		while (true) {
			System.out.println("Wanna play again?");
			answer = sc.nextLine();
			if (!(answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("yes"))) {
				System.out.println("Please, say yes or no");
			} else {
				break;
			}

			if (answer.equalsIgnoreCase("no")) {
				break;
			}
		}
	}

	static boolean isWinner(String[][] matrix) {
		if ((matrix[0][0] == matrix[0][1] && matrix[0][1] == matrix[0][2]
				&& !(matrix[0][0] == " " && matrix[0][1] == " " && matrix[0][2] == " "))
				|| (matrix[1][0] == matrix[1][1] && matrix[1][1] == matrix[1][2]
						&& !(matrix[1][0] == " " && matrix[1][1] == " " && matrix[1][2] == " "))
				|| (matrix[2][0] == matrix[2][1] && matrix[2][1] == matrix[2][2]
						&& !(matrix[2][0] == " " && matrix[2][1] == " " && matrix[2][2] == " "))
				|| (matrix[0][0] == matrix[1][0] && matrix[1][0] == matrix[2][0]
						&& !(matrix[0][0] == " " && matrix[1][0] == " " && matrix[2][0] == " "))
				|| (matrix[0][1] == matrix[1][1] && matrix[1][1] == matrix[2][1]
						&& !(matrix[0][1] == " " && matrix[1][1] == " " && matrix[2][1] == " "))
				|| (matrix[0][2] == matrix[1][2] && matrix[1][2] == matrix[2][2]
						&& !(matrix[0][2] == " " && matrix[1][2] == " " && matrix[2][2] == " "))
				|| (matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2]
						&& !(matrix[0][0] == " " && matrix[1][1] == " " && matrix[2][2] == " "))
				|| (matrix[0][2] == matrix[1][1] && matrix[1][1] == matrix[2][0])
						&& !(matrix[0][2] == " " && matrix[1][1] == " " && matrix[2][0] == " ")) {
			return true;
		} else {
			return false;
		}
	}

	static void printMatrix(String[][] matrix) {
		System.out.println("---------------");
		System.out.println("|" + matrix[0][0] + "|" + matrix[0][1] + "|" + matrix[0][2] + "|");
		System.out.println("---------------");
		System.out.println("|" + matrix[1][0] + "|" + matrix[1][1] + "|" + matrix[1][2] + "|");
		System.out.println("---------------");
		System.out.println("|" + matrix[2][0] + "|" + matrix[2][1] + "|" + matrix[2][2] + "|");
		System.out.println("---------------");
	}

	public static void isValid(int row, int col, String[] arr, String[][] matrix, String sign) {
		Scanner sc = new Scanner(System.in);
		while (row > 3 || row < 1 || col > 3 || col < 1) {
			System.out.println("Invalid input!");
			System.out.println("Select coordinates!(ex: 1,1)");
			arr = sc.nextLine().trim().split("\\s*,\\s*");
			row = Integer.parseInt(arr[0]);
			col = Integer.parseInt(arr[1]);
		}
		while (true) {
			if (matrix[row - 1][col - 1].equals(" ")) {
				matrix[row - 1][col - 1] = sign;
				break;
			} else {
				System.out.println("Invalid input! These coordinates are already selected!");
				System.out.println("Select other coordinates!");
				arr = sc.nextLine().split("\\s*,\\s*");
				row = Integer.parseInt(arr[0]);
				col = Integer.parseInt(arr[1]);
			}
		}
	}
}
