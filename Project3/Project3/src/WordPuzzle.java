/**
 * Use the hash table to solve a word puzzle.
 * @author simonwang
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.lang.NullPointerException;

public class WordPuzzle {
	
	public static void main(String[] args) 
	{
		char grid[][] = newgrid();//create new grid
		
		System.out.println("####################Words Puzzle#######################"); //print grid
		printgrid(grid);
		
		MyHashTable hashTable = new MyHashTable();// Initialize data structures
		
		File file = new File("src/dictionary.txt");// Read file to data structures
		BufferedReader buffer = null;
		try {
			buffer = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//Way1- Normal dictionary
		System.out.println();
		System.out.println("#################1) Normal dictionary##################");
		String dicString;//Store the dictionary text to Hashtable
		try {
			while ((dicString = buffer.readLine()) != null) {
				hashTable.insert(dicString);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try { //End read
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("###############Words Find in Hashtable#################"); //solve the puzzle
		long startTime = System.currentTimeMillis();
		traversePuzzle(grid, hashTable, 1);
		long endTime = System.currentTimeMillis();
		
		
		//Way2- Add prefix into dictionary
		System.out.println();
		System.out.println("#############2) Add prefix into dictionary#############");
		
		try {
			buffer = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String dicString2;//Store the dictionary text to Hashtable
		try {
			while ((dicString2 = buffer.readLine()) != null) {
				String prefix = "";
				for(int i=0; i < dicString2.length(); i++)
				{
					prefix = prefix + dicString2.charAt(i);
					hashTable.insert(prefix);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		try { //End read
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("###############Words Find in Hashtable#################"); //solve the puzzle
		long startTime2 = System.currentTimeMillis();
		traversePuzzle(grid, hashTable, 2);
		long endTime2 = System.currentTimeMillis();
		System.out.println();
		System.out.println("1) The running time of normal dictionary is : " + (endTime - startTime));
		System.out.println("2) The running time of added prefix into dictionary is : " + (endTime2 - startTime2));
		
//		//print Hashtable
//		System.out.println("###############Dictionary in Hashtable#################");
//		hashTable.printHash();
//		System.out.println("#######################################################");
		
	}
	
	public static int row;
	public static int col;
	
	public static char[][] newgrid() //create new grid
	{
		Scanner scRow = new Scanner(System.in);
		System.out.println("Please enter the row of the grid");
		row = scRow.nextInt();
		Scanner scCol = new Scanner(System.in);
		System.out.println("Please enter the column of the grid");
		col = scCol.nextInt();
		
		char newgrid[][] = new char[row][col];//Random English Char create in new grid
		for (int i = 0; i <= row - 1; i++)
			for (int j = 0; j <= col - 1; j++) 
				newgrid[i][j] = (char)('a' + Math.random()*26);
		
		return newgrid;
	}
	
	public static void printgrid(char a[][])//print grid
	{
		for(int i=0; i<= a.length-1; i++)
		{
			for(int j=0; j <= a[0].length-1; j++)
			{
				System.out.print(" " + a[i][j]);
			}
			System.out.println();
		}		
			
	}
	
	public static void traversePuzzle(char grid[][], MyHashTable<String> hashTable, int way)//traverse the puzzle
	{
		for(int i=0; i <= grid.length-1; i++ )
			for(int j=0; j<=grid[0].length-1; j++)
			{
				for(int leftright = -1; leftright <= 1; leftright++)//check the puzzle
					for(int updown = -1; updown <= 1; updown++)
					{
						if(leftright != 0 || updown !=0)//Have movement
						{
							if(way == 1)
								checkPuzzle1(i, j, leftright, updown, grid, hashTable);
							if(way == 2)
								checkPuzzle2(i, j, leftright, updown, grid, hashTable);
							
						}
							
					}
				
			}
	}
	
	public static void checkPuzzle1(int i, int j, int leftright, int updown, char grid[][], MyHashTable<String> hashTable)//check the puzzle
	{
		String stringCheck="";
		stringCheck = stringCheck + grid[i][j];
		for(int x = i + leftright, y = j + updown; x >=0 && y >= 0 && x <= grid.length-1 && y <= grid.length-1; 
				x = x + leftright, y = y + updown)
		{
			stringCheck = stringCheck + grid[x][y];
			if(hashTable.contains(stringCheck))//Have prefix
				System.out.println("Find word : " + stringCheck + ", From [ " + i +", " + j + "] to [ " + x + ", " + y + "] ");
		}
	}
	
	public static void checkPuzzle2(int i, int j, int leftright, int updown, char grid[][], MyHashTable<String> hashTable)//check the puzzle
	{
		String stringCheck="";
		stringCheck = stringCheck + grid[i][j];
		for(int x = i + leftright, y = j + updown; x >=0 && y >= 0 && x <= grid.length-1 && y <= grid.length-1; 
				x = x + leftright, y = y + updown)
		{
			stringCheck = stringCheck + grid[x][y];
			if(hashTable.contains(stringCheck))//Have prefix
				System.out.println("Find word : " + stringCheck + ", From [ " + i +", " + j + "] to [ " + x + ", " + y + "] ");
			else//No prefix, then skip
				break;
		}
	}

}
