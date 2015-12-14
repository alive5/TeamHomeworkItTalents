import java.util.Scanner;

public class Horse {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Въведете брой редове и колони: ");
		int rows = sc.nextInt();
		int cols = sc.nextInt();

		char[][] matrix = new char[rows][cols];

		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				matrix[r][c] = ' ';
			}
		}
		System.out.println("Въведете координати на начална позиция: ");
		int startRow = sc.nextInt();
		int startCol = sc.nextInt();

		paint(matrix, startRow, startCol);

		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				System.out.print(matrix[r][c]);
			}
			System.out.println();
		}

	}

	static void paint(char[][] matrix, int row, int col) {

		if (row < 0 || row >= matrix.length) {
			return;
		}
		if (col < 0 || col >= matrix[0].length) {
			return;
		}
		if (matrix[row][col] != ' ') {
			return;
		}

		matrix[row][col] = '.';

		// left
		paint(matrix, row - 1, col - 2);
		paint(matrix, row + 1, col - 2);
		// up
		paint(matrix, row - 2, col - 1);
		paint(matrix, row - 2, col + 1);
		// right
		paint(matrix, row - 1, col + 2);
		paint(matrix, row + 1, col + 2);
		// down
		paint(matrix, row + 2, col - 1);
		paint(matrix, row + 2, col + 1);

	}

}
