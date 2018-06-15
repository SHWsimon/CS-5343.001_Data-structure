import java.util.Scanner;

public class RecursionA
{
	public static void main(String[] args) 
	{  
		Scanner scanner = new Scanner(System.in);
		System.out.print("n="); 
		int num = scanner.nextInt();
		print(num);

	} 
	
	public static void print(int n)
	{
		if(n<=0)
			printword(n);
		else
		{
			printword(n);
			print(n-1);
			printword(n);
		}	
	}
	
	public static void printword(int input)
	{
		System.out.print(input+" "); 
	}

}