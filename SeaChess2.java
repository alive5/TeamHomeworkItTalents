import java.util.Scanner;

public class SeaChess2 {

	
	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
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
        
        
        String answer="";
        while(true){
        System.out.println("Wanna play again?");
        answer = sc.nextLine();
         if (!(answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("yes"))) {
                 System.out .println("Please, say yes or no");
         } else {
                 break;
         }
	

 if (answer.equalsIgnoreCase("no")) {
         break;
 }
	}
        }
		static boolean isWinner(String[][] matrix) {
             if ((matrix[0][0] == matrix[0][1] && matrix[0][1] == matrix[0][2] && !(matrix[0][0] == " "
                             && matrix[0][1] == " " && matrix[0][2] == " "))
                             || (matrix[1][0] == matrix[1][1]
                                             && matrix[1][1] == matrix[1][2] && !(matrix[1][0] == " "
                                             && matrix[1][1] == " " && matrix[1][2] == " "))
                             || (matrix[2][0] == matrix[2][1]
                                             && matrix[2][1] == matrix[2][2] && !(matrix[2][0] == " "
                                             && matrix[2][1] == " " && matrix[2][2] == " "))
                             || (matrix[0][0] == matrix[1][0]
                                             && matrix[1][0] == matrix[2][0] && !(matrix[0][0] == " "
                                             && matrix[1][0] == " " && matrix[2][0] == " "))
                             || (matrix[0][1] == matrix[1][1]
                                             && matrix[1][1] == matrix[2][1] && !(matrix[0][1] == " "
                                             && matrix[1][1] == " " && matrix[2][1] == " "))
                             || (matrix[0][2] == matrix[1][2]
                                             && matrix[1][2] == matrix[2][2] && !(matrix[0][2] == " "
                                             && matrix[1][2] == " " && matrix[2][2] == " "))
                             || (matrix[0][0] == matrix[1][1]
                                             && matrix[1][1] == matrix[2][2] && !(matrix[0][0] == " "
                                             && matrix[1][1] == " " && matrix[2][2] == " "))
                             || (matrix[0][2] == matrix[1][1] && matrix[1][1] == matrix[2][0])
                             && !(matrix[0][2] == " " && matrix[1][1] == " " && matrix[2][0] == " ")) {
                     return true;
             } else {
                     return false;
             }
	}
		static void printMatrix(String[][] matrix) {
              System.out.println("---------------");
              System.out.println("|"+ matrix[0][0]+"|"+ matrix[0][1]+"|"+
                              matrix[0][2]+"|");
              System.out.println("---------------");
              System.out.println("|"+matrix[1][0]+"|"+  matrix[1][1]+"|"+ 
                              matrix[1][2]+"|");
              System.out.println("---------------");
              System.out.println("|"+matrix[2][0]+"|"+  matrix[2][1]+"|"+ 
                              matrix[2][2]+"|");
              System.out.println("---------------");
      }

}
