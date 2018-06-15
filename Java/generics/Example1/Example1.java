// by Greg Ozbirn, University of Texas at Dallas, Spring 2008,
// adapted from examples in "Java Generics and Collections",
// by Maurice Naftalin and Philip Wadler, Copyright 2006,
// O'Reilly Media, Inc., 0-596-52775-6


import java.util.List;
import java.util.ArrayList;

public class Example1
{
	public static void main(String args[])
	{
/*	
 		// the Java 1.4 way
		List words = new ArrayList();
		words.add("Hello");
		words.add(1);
		
		String str = (String)words.get(0);
		Integer num = (Integer)words.get(1);
*/	
	
		// the Java Generics way
		List<String> words = new ArrayList<String>();
		words.add("Hello");
		words.add(1);    // will this work?
		
		String str = words.get(0);  // notice the auto-unboxing
		
	
	}
	
}