// by Greg Ozbirn, University of Texas at Dallas, Spring 2008,
// adapted from examples in "Java Generics and Collections",
// by Maurice Naftalin and Philip Wadler, Copyright 2006,
// O'Reilly Media, Inc., 0-596-52775-6


import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Example3
{
	public static void printlist(List<Number> nums)
	{
		for ( Number n : nums )
		{
			System.out.println(n);
		}
	}
	
	
	public static void main(String args[])
	{
	
		List<Number> nums = new ArrayList<Number>();
		nums.add(1);
		nums.add(2);
		
		List<Integer> ints = Arrays.asList(1, 2);
		
		
		printlist(nums);
		
		printlist(ints);  // will this work?
		
	
	}
	
}