import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * This program demonstrates a two-dimensional array.
 */

public class CorpSales
{
	public static void main(String[] args)
	{
		final int DIVS = 3; // Three divisions in the company
		final int QTRS = 4; // Four quarters

		// Create an array to hold the sales for each
		// division, for each quarter.
		double[][] sales = new double[DIVS][QTRS];
		
		double totalSales = 0;

		System.out.println("The number of rows in sales array is " + sales.length);
		System.out.println("The number of columns is " + sales[0].length);
		
		// Create a Scanner object for keyboard input.
		Scanner keyboard = new Scanner(System.in);

		// Display an introduction.
		System.out.println("This program will calculate the " 
				+ "total sales of");
		System.out.println("all the company's divisions for each quarter. ");
		System.out.println("Enter the following sales data:");

		// Nested loops to fill the array with quarterly
		// sales figures for each division.
		//Iterate through each division row
		for (int divRow = 0; divRow < DIVS; divRow++)
		{
			//iterate through each quarter column
			for (int qtrCol = 0; qtrCol < QTRS; qtrCol++)
			{
				System.out.print("Division " + (divRow + 1)
						+ ", Quarter " + (qtrCol + 1)
						+ ": $");
				sales[divRow][qtrCol] = keyboard.nextDouble();
			}
			System.out.println();   // Print blank line.
		}
	
		//call method to display 2d array
		display2DArray(sales);
		//call method to calculate array sum of all sales
		totalSales = calculateArraySum(sales);
		// Display the total sales.
		System.out.println("total sales is: " + totalSales+"$");
		//Display max sale
		double maxSale = findMax(sales);
		System.out.println("Max sale is: " + maxSale);
		System.out.println(" Divs and qrts has max sale is "+findDivsAndQrtsOfMaxSale(sales));
		keyboard.close();
		
	}//end main
	

	//Write method to display2DArray
	public static void display2DArray(double[][] anArray ) {
		System.out.println("Display of array:");
		for (int row = 0; row < anArray.length; row++) {
			for(int col = 0; col < anArray[row].length; col++) {
				System.out.print(""+ anArray[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	//find max
	public static double findMax(double[][] anArray) {
		double max = anArray[0][0];
		for (int row = 0; row < anArray.length; row++) {
			for(int col = 0; col < anArray[row].length; col++) {
				if(anArray[row][col]>max) {
					max=anArray[row][col];
				}
			}
		}
	return max;
	}
	//find divs and qrts of max sale
	public static int[] findDivsAndQrtsOfMaxSale(double[][] anArray) {
		int divs = 0;
		int qrts = 0;
		double max = anArray[0][0];
		for (int row = 0; row < anArray.length; row++) {
			for(int col = 0; col < anArray[row].length; col++) {
				if (anArray[row][col]> max ) {
					max = anArray[row][col];
					divs = row;
					qrts = col;
				}
			}
		}
		return new int[] {divs,qrts};
	}
	//write method calculateArraySum
	public static double calculateArraySum(double[][] anArray) {
		double sumOfArray = 0;
		for (int row = 0; row < anArray.length; row++) {
			for(int col = 0; col < anArray[row].length; col++) {
				sumOfArray += anArray[row][col];
			}
		}
	return sumOfArray;
	}

}