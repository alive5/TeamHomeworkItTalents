import java.util.Scanner;

//Имате двумерен масив от числа, чийто стойности са въведени
//предварително. Да се отпечатат сумата на елементите на масива,
//както и средноаритметичното на тези числа.

public class Zadacha3SrednoAritmetichno {

	public static void main(String[] args) {
		int[][] arr = {
				{1,4,6,3},
				{5,9,7,2},
				{4,8,1,9},
				{2,3,4,5}
				};
		//Scanner sc = new Scanner(System.in);
 float sum = 0f;

 
		for ( int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {

				//arr[row][col] = sc.nextInt();
             sum += arr[row][col];
//				System.out.print(arr[row][col] + " ");
			}
		
		}
		System.out.println(sum);
		System.out.println(sum/16);
	}

}
