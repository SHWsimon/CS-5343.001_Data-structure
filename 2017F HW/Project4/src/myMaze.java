/**
 * Use disjSets to create a maze.
 * @author simonwang
 */

import java.util.Random;
import java.util.Scanner;

public class myMaze {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input Row number : ");
		int n = scanner.nextInt();
		System.out.print("Input Column number: ");
		int m = scanner.nextInt();
		int numCells = n * m;
		
		//Build new maze
		myMaze maze = new myMaze();
		int Grid[][] = new int[numCells][4];
		Grid = maze.buildMaze(numCells, n, m);
		
		//Print Top 
		System.out.print(" _");
		for(int i = 1; i < m; i++)
			System.out.print(" _");
		System.out.println();
		System.out.print("*");
		
		//Print Maze
		for(int x = 0; x < numCells; x++)
		{
			//Grid[0][0] don't print
			if(x != 0)
			{
				//left "|"
				if( Grid[x][0] >= 0)
					System.out.print("|");
				if( Grid[x][0] < 0)
					System.out.print(" ");
			}
			//bottom "_"
			if( Grid[x][3] >= 0)
				System.out.print("_");
			if( Grid[x][3] < 0)
				System.out.print(" ");
			
			//right "|" wall 
			if((x+1) % m == 0)
			{
				//detect endpoint
				if(x != numCells - 1)
				{
					System.out.print("|");
					System.out.println("");
				}
				else
					System.out.print("*");
			}	
		}
	}
	
	public static int[][] buildMaze(int num, int n, int m) {
		int numCells = num;
		int max = num - 1;
		int grid[][] = new int[num][4];
		DisjSets ds = new DisjSets(num);
		for(int i = 0; i < num; i++)
		{
			grid[i][0] = 0; // "left |"
			grid[i][1] = 1; // "top _"
			grid[i][2] = 2; // "right |"
			grid[i][3] = 3; // "botton _"
		}

		while(numCells > 1)
		{
			//(Cells, walls) = (X,Y)
			//Random X 
			Random randomX = new Random();
			int x = randomX.nextInt() % num;
			if(x < 0)
				x += num;
			//Random Y
			Random randomY = new Random();
			int y = randomY.nextInt() % 4;
			if(y < 0)
				y += 4;
			
			//Break Wall
			if(y == 0)
			{
				//Avoid to break first column left "|"
				if(!(x % m == 0))
				{
					if(ds.find(x) != ds.find(x-1))
					{
						ds.union(ds.find(x), ds.find(x-1));
						grid[x][0] = -1;
						grid[x-1][2] = -1;
						numCells--;
					}
				}
			}
			else if(y == 1)
			{
				//Avoid to break first row top "_"
				if(!(x < m))
				{
					if(ds.find(x) != ds.find(x-m))
					{
						ds.union(ds.find(x), ds.find(x-m));
						grid[x-m][3] = -1;
						grid[x][1] = -1;
						numCells--;
					}
				}
			}
			else if(y == 2)
			{
				//Avoid to break first column left "|"
				if(!((x+1) % m == 0))
				{
					if(ds.find(x) != ds.find(x+1))
					{
						ds.union(ds.find(x), ds.find(x+1));
						grid[x+1][0] = -1;
						grid[x][2] = -1;
						numCells--;
					}
				}
			}
			else if(y == 3)
			{
				//Avoid to break last row bottom "_"
				if(!(x > (max-m)))
				{
					if(ds.find(x) != ds.find(x+m))
					{
						ds.union(ds.find(x), ds.find(x+m));
						grid[x][3] = -1;
						grid[x+m][1] = -1;
						numCells--;
					}
				}
			}
		}
		//start point & end point show be " "
		grid[0][0] = -1;
		grid[num-1][2] = -1;
		
		return grid;
	}
}
