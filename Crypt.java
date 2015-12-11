
public class Crypt {

	// static void createRandomKey() {
	// for (int index = 0; index < 5; index++) {
	// for (int i = 0; i < 5; i++) {
	// int n = (int) (Math.random() * ('Y' - 'A') + 'A');
	// System.out.print((char) n + " ");
	// }
	// System.out.println();
	// }
	// }

	static void encrypt(String input, char[][] matrix) {

		input = input.toUpperCase();
		if (input.length() % 2 != 0) {
			input = input + "P";
		}

		char currentFirstChar = 0;
		char currentSecondChar = 0;

		System.out.println("Encrypt: ");
		for (int index = 0; index < input.length() - 1; index += 2) {
			currentFirstChar = input.charAt(index);
			if (currentFirstChar == 'Z') {
				currentFirstChar = 'A';
			}
			currentSecondChar = input.charAt(index + 1);
			if (currentSecondChar == 'Z') {
				currentSecondChar = 'A';
			}

			// find the coordinates of the symbols in the matrix
			int firstCharRow = 0, firstCharColumn = 0, secondCharRow = 0, secondCharColumn = 0;
			for (int row = 0; row < matrix.length; row++) {
				for (int col = 0; col < matrix[0].length; col++) {
					if (matrix[row][col] == currentFirstChar) {
						firstCharRow = row;
						firstCharColumn = col;
					}

					if (matrix[row][col] == currentSecondChar) {
						secondCharRow = row;
						secondCharColumn = col;
					}
				}
			}

			if (firstCharRow == secondCharRow) {
				if (firstCharColumn <= matrix[0].length - 2) {
					firstCharColumn++;
				} else {
					firstCharColumn = 0;
				}
				if (firstCharColumn <= matrix[0].length - 2) {
					secondCharColumn++;
				} else {
					secondCharColumn = 0;
				}
				System.out.print(matrix[firstCharRow][firstCharColumn] + " ");
				System.out.print(matrix[secondCharRow][secondCharColumn] + " ");
			} else {
				if (firstCharColumn == secondCharColumn) {
					if (firstCharRow <= matrix.length - 2) {
						firstCharRow++;
					} else {
						firstCharRow = 0;
					}
					if (secondCharRow <= matrix.length - 2) {
						secondCharRow++;
					} else {
						secondCharRow = 0;
					}
					System.out.print(matrix[firstCharRow][firstCharColumn] + " ");
					System.out.print(matrix[secondCharRow][secondCharColumn] + " ");
				} else {
					System.out.print(matrix[firstCharRow][secondCharColumn] + " ");
					System.out.print(matrix[secondCharRow][firstCharColumn] + " ");
				}
			}
		}
		System.out.println();

	}

	public static void main(String[] args) {

		char[][] matrix = { { 'G', 'E', 'F', 'U', 'J' }, { 'M', 'I', 'N', 'B', 'S' }, { 'C', 'T', 'A', 'L', 'R' },
				{ 'D', 'H', 'Y', 'V', 'O' }, { 'K', 'W', 'Q', 'X', 'P' } };

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				System.out.print(matrix[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();

		encrypt("utlxpg", matrix);
		encrypt("GEINV", matrix);
		encrypt("Zdj", matrix);

	}

}
