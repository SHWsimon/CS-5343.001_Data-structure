import java.util.Scanner;
public class Scores<T>
{
	public static void main(String[] args)
	{
		String[] n=new String[10];
		int[][] s=new int[10][5];
		int STUNUM=10;
		int SCNUM=5;
		for(int i=0; i<STUNUM; i++)
		{
			System.out.println("Student " + (i+1));
			System.out.print("Name: ");
			Scanner sc= new Scanner(System.in);
			String name=sc.next();
			n[i]=name;
			int Sum=0;
			int Avg=0;
			for(int j=0; j<SCNUM;j++)
			{
				System.out.print("Score " + (j+1) + " =");
				int scores=sc.nextInt();
				Sum+=scores;
			}
			Avg=Sum/SCNUM;
			s[i][i]=Avg;
		}
		for(int i=0; i<STUNUM; i++)
			//for(int j=0; j<SCNUM; j++)
			{
				System.out.println(n[i] + " " + s[i][i]);
			}
		
	}
	
} 