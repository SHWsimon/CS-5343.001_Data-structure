// by Greg Ozbirn, University of Texas at Dallas, Spring 2008,
// adapted from examples in "Java Generics and Collections",
// by Maurice Naftalin and Philip Wadler, Copyright 2006,
// O'Reilly Media, Inc., 0-596-52775-6


import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Example4
{
	public static <T> void copy(List<? super T> dst, List<? extends T> src)
	{
		int i=0;
		for ( T n : src )
		{
			dst.set(i, src.get(i));
			i++;
		}
	}
	
	
	public static void main(String args[])
	{
	
		List<Number> nums = new ArrayList<Number>();
		nums.add(2.78);
		nums.add(3.14);
		
		List<Integer> ints = Arrays.asList(1, 2);
				
		copy(nums, ints);  // will this work?
		
		copy(ints, nums);  // will this work?
					
	}
	
}