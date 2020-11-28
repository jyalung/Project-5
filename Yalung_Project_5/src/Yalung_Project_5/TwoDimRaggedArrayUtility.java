package Yalung_Project_5;

import java.io.*;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {
	
	public TwoDimRaggedArrayUtility() {
		
	}
	
	public static double[][] readFile(File file) throws FileNotFoundException{
		Scanner sc = new Scanner(file);
	    int rowIndex = 0;
	    String[][] tempArray = new String[10][]; 
	    
	    while (sc.hasNextLine())
	    {
	    	String[] row = sc.nextLine().split(" ");
	    	tempArray[rowIndex] = new String[row.length];
	    	for (int i = 0;i < row.length;i++)
	    	{
	    		tempArray[rowIndex][i]=row[i]; 
	    	}
	    	rowIndex++;
	    }
	    
	    double[][]saleArray = new double[rowIndex][];
	    for (int i = 0; i < rowIndex;i++)
	    {
	    	saleArray[i]= new double[tempArray[i].length];
	    	for (int j = 0;j < tempArray[i].length;j++)
	    	{
	    		System.out.print(tempArray[i][j] + " ");
	    		saleArray[i][j] = Double.parseDouble(tempArray[i][j]);
	    	}
	    	System.out.println();
	    }
	    
	    sc.close();
	    return saleArray;
	}
	
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException
	{
		PrintWriter output = new PrintWriter(outputFile);
		
		for (int row = 0; row < data.length; row++)
		{
			
			for (int column = 0; column < data[row].length; column++)
			{
				if (column != 0)
				{
					output.print(" " + data[row][column]);
				}else {
					output.print(data[row][column]);
				}
			}
			output.println();
		}
		output.close();
	}
	
	public static double getTotal(double[][] data)
	{
		double total = 0;

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				total += data[i][j];

			}

		}
		return total;
	}
	
	public static double getAverage(double[][] data) {
		int elements = 0;  
		
		for (int row = 0; row < data.length; row++)
		{
			for (int column = 0; column < data[row].length; column++)
			{
				elements++;
			}
		}
		return getTotal(data)/elements;
	}
	
	public static double getRowTotal(double[][] data, int row) {
		double total = 0;
		for (int column = 0; column < data[row].length; column++)
		{
			total += data[row][column];
		}
		return total;
	}
	
	public static double getColumnTotal(double[][] data, int col) {
		double total = 0;
		for (int row = 0; row < data.length; row++)
		{
			if (col < data[row].length)
			{
				total += data[row][col];
			}
		}
		return total;
	}
	
	public static double getHighestInRow(double[][] data, int row) {
		double largest = 0;
		for(int i=0; i<data[row].length; i++)
		{
			if (data[row][i] > largest)
				largest = data[row][i];
		}
		
		return largest;
	}
	
	public static int getHighestInRowIndex(double[][] data, int row) {
		double max = data[row][0];
		int temp = 0;
		for (int j = 0; j < data[row].length; j++) {
			if (data[row][j] > max) {
				max = data[row][j];
				temp = j;
			}
		}
		return temp;
	}
	
	public static double getLowestInRow(double[][] data, int row) {
		double min = data[row][0];
		for (int j = 0; j < data[row].length; j++) {
			if (data[row][j] < min) {
				min = data[row][j];
			}
		}
		return min;
	}
	
	public static int getLowestInRowIndex(double[][] data, int row) {
		double low = data[row][0];
		int index = 0;
		
		for(int i = 0; i < data[row].length; i++) {
			
			if(data[row][i] < low) {
				
				low = data[row][i];
				index = i;
			}
			
		}
		
		return index;
	}
	
	public static double getHighestInColumn(double[][] data, int col) {
		double largestCol = 0;
		for (int i=0; i < data.length; i++)
		{
			if (data[i].length > col && data[i][col]>largestCol)
			{
				largestCol = data[i][col];
			}
		}
		
		return largestCol;
	}
	
	public static int getHighestInColumnIndex(double[][] data, int col) 
	{
		double largestCol = 0;		
		int index = 0;
		for (int i = 0; i < data.length; i++)
		{
			if (data[i].length > col && data[i][col]>largestCol)
			{
				largestCol = data[i][col];
				index = i;
			}
		}
		
		return index;
	}
	
	public static double getLowestInColumn(double[][] data, int col) {
		
		int count = 0;
		double low = 0;
		
		for(int i = 0; i < data.length; i++) {			
			for(int j = 0; j < data[i].length; j++) {				
				if(j == col) {
					if(count < 1) {
						low = data[i][j];
						count++;
					}
					if(data[i][j] < low) {						
						low = data[i][j];						
					}					
				}				
			}			
		}
		return low;		
	}
	
	public static int getLowestInColumnIndex(double[][] data, int col) {
		int index = 0;
		int count = 0;
		double low = 0;
		
		for(int i = 0; i < data.length; i++) {			
			for(int j = 0; j < data[i].length; j++) {
				if(j == col) {
					if(count < 1) {
						low = data[i][j];
						index = i;
						count++;
					}					
					if(data[i][j] < low) {
						
						low = data[i][j];
						index = i;
						
					}
					
				}
				
			}
			
		}
		
		return index;
		
		
	}
	
	public static double getHighestInArray(double[][] data) {
		double highest = 0;

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if (data[i][j] > highest) {
					highest = data[i][j];
				}
			}

		}
		return highest;
	}
	
	public static double getLowestInArray(double[][] data) {
		double low = data[0][0];
		for (int row = 0; row < data.length; row++)
		{
			for (int column = 0; column < data[row].length; column++)
			{
				if (low > data[row][column])
				{
					low = data[row][column];
				}
			}
		}
		return low;
	}
	 
}
