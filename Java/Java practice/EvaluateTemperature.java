import java.util.Scanner;

public class EvaluateTemperature<T>
{
	public static String Evaluate(int t)
	{
		if(t==0)
			return "extremely cold";
		else if(t>=0 && t<=32)
			return "Very cold";
		else if(t>=33 && t<=50)
			return "Cold";
		else if(t>=51 && t<=70)
			return "Mild";
		else if(t>=71 && t<=90)
			return "Warm";
		else if(t>=91 && t<=100)
			return "Hot";
		else 
			return "Very Hot";
	}
	
	public static void main(String[] args) 
	{  
		Scanner scanner = new Scanner(System.in);
		System.out.println("Celsius(C) or Fahrenheit(F)");
		System.out.print("Temperature="); 
		int temp = scanner.nextInt();
		String unit = scanner.next();
		// temperature exchange
		if(unit.equals("C"))
			temp=((temp*9/5)+32);
		//Evaluate temperature
		String result=Evaluate(temp);
		//print result
		System.out.println("Temperature="+temp+" F");
		System.out.println(result);
	} 
}