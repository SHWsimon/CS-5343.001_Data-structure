/**
 * Modify the author's "MyLinkedList" class to add the following methods
 * @author simonwang
 */

import java.util.HashMap;
import java.util.Scanner;
import java.util.List;
import java.util.*;

public class MyStack 
{
	public static void main(String[] args)
	{
		System.out.print("Please Enter Your Formula : ");
		Scanner scanner = new java.util.Scanner(System.in);
		String input = scanner.nextLine();
		System.out.println();
		Stack myStack = new Stack();
		myStack.SymbolTest(input);
	}
}

class Stack<AnyType>
{
	List<AnyType> arraylst = new ArrayList<AnyType>();
	private int num;
	private int top;
	
	public AnyType pop()
	{
		AnyType chr = arraylst.remove(arraylst.size()-1);
		return chr;
	}
	
	public void push(AnyType chr)
	{
		arraylst.add(chr);
	}
	
	//Missing Symbols map
	public char missOperator(char element)
	{
		HashMap map = new HashMap();
		map.put('{', '}');
		map.put('[', ']');
		map.put('(', ')');
		map.put('}', '{');
		map.put(']', '[');
		map.put(')', '(');
		
		return (char)map.get(element);
	}
	
	//Priority on Symbols
	public int priority(char operator)
	{
		HashMap map = new HashMap();
		map.put('{', 1);
		map.put('}', 1);
		map.put('(', 2);
		map.put(')', 2);
		map.put('[', 3);
		map.put(']', 3);
		if(map.get(operator) != null)
			return (int)map.get(operator);
		else
			return 0;
		}
	
	public void SymbolTest(String input)
	{
		Stack stack = new Stack();
		for(int i=0; i< input.length(); i++)
		{
			char chr = input.charAt(i);
			//detect {, }, (, ), [, ]
			if(chr == '[' || chr == '(' || chr == '{')
			{
				stack.push(chr);
				top++;
			}
			else if(chr == '}' || chr == ')' || chr==']')
			{
				//stack not empty
				if(top > 0)	
				{
					//Pop() stack
					char chx = (char)stack.arraylst.remove(stack.arraylst.size()-1);
					top--;
					//Pop() stack element is not same as chr
					if( ('{' != chx && chr == '}') || (chr == ')' && '(' != chx) || ('[' != chx && chr == ']'))
					{
						//chr > Stack element
						if(stack.priority(chr) > stack.priority(chx))
						{
							System.out.println("Symbol error: " + chr + " at index " + i);
							System.out.println("Miss operator " + missOperator(chx));
							i--;
						}
						//chr < Stack element
						else
						{
							stack.push(chx);
							top++;
							System.out.println("Symbol error: " + chr + " at index " + i);
							System.out.println("Miss operator " + missOperator(chr));
						}
						
					}
				}
				//stack is empty 
				else 
				{
					System.out.println("Symbol error: " + chr + " at index " + i);
					System.out.println("Miss operator " + missOperator(chr));
				}

			}
		}		
		//stack not empty
		while(top > 0)
		{
			char chx = (char)stack.arraylst.remove(stack.arraylst.size()-1);
			System.out.println("Miss operator " + missOperator(chx));
			top--;
		}
	}
}
