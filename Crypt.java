import java.util.Arrays;

public class Crypt {

	public static void main(String[] args) {

		char[][] key = generateRandomKey();

		// System.out.println(Arrays.deepToString(key));

		for (int row = 0; row < key.length; row++) {
			for (int col = 0; col < key[0].length; col++) {
				System.out.print(key[row][col] + " ");

			}
			System.out.println();
		}
		encrypt("utlxpg", key);
		encrypt("GEINV", key);
		encrypt("Zdj", key);
		decrypt("QYOU", key);

	}

	static char generateRandomChar() {
		return (char) (Math.random() * ('Z' - 'A') + 'A');
	}

	// check if the letter already exist in the key/matrix
	static boolean isExist(char[][] matrix, char ch) {
		boolean exist = false;
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				if (matrix[row][col] == ch) {
					exist = true;
				}
			}
		}
		return exist;
	}

	static char generateUniqueChar(char[][] matrix) {
		char genChar = generateRandomChar();
		boolean findUniqueChar = false;

		do {
			if (!isExist(matrix, genChar)) {
				findUniqueChar = true;
			} else {
				genChar = generateRandomChar();
			}
		} while (!findUniqueChar);

		return genChar;
	}

	// create matrix - key
	static char[][] generateRandomKey() {
		char[][] matrix = new char[5][5];
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				matrix[row][col] = generateUniqueChar(matrix);
				// System.out.print(matrix[row][col] + " " );
			}
			// System.out.println();
		}

		return matrix;

	}

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
					firstCharRow++;
					if (firstCharRow > matrix.length - 1) {
						firstCharRow = 0;
					}
					secondCharRow++;
					if (secondCharRow > matrix.length - 1) {
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

	static void decrypt(String input, char[][] matrix) {

		char currentFirstChar = 0;
		char currentSecondChar = 0;

		System.out.println("Decrypt: ");
		for (int index = 0; index < input.length() - 1; index += 2) {
			currentFirstChar = input.charAt(index);
			currentSecondChar = input.charAt(index + 1);

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
				firstCharColumn--;
				if (firstCharColumn < 0) {
					firstCharColumn = matrix[0].length;
				}
				secondCharColumn--;
				if (firstCharColumn < 0) {
					secondCharColumn = matrix[0].length;
				}
				System.out.print(matrix[firstCharRow][firstCharColumn] + " ");
				System.out.print(matrix[secondCharRow][secondCharColumn] + " ");
			} else {
				if (firstCharColumn == secondCharColumn) {
					firstCharRow--;
					if (firstCharRow < 0) {
						firstCharRow = matrix.length;
					}
					secondCharRow--;
					if (secondCharRow < 0) {
						secondCharRow = matrix.length;
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

}
