// by Greg Ozbirn, University of Texas at Dallas, Spring 2008,
// adapted from examples in "Java Generics and Collections",
// by Maurice Naftalin and Philip Wadler, Copyright 2006,
// O'Reilly Media, Inc., 0-596-52775-6


import java.util.List;
import java.util.ArrayList;

public class Example2
{
	public static void main(String args[])
	{
	
		List<Number> nums = new ArrayList<Number>();
		
		nums.add(1);      
		nums.add(3.14);
		
		for ( Number n : nums )
		{
			System.out.println(n);
		}
		
		
		List<Integer> ints = new ArrayList<Integer>();
		
		nums = ints;  // will this work?  
		
	
	}
	
}