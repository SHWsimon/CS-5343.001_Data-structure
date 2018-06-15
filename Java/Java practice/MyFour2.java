import java.util.LinkedList;
import java.util.Scanner;

public class MyFour2<T> 
{
	private T item;
	private Boolean condition=false;
	private LinkedList<T> list= new LinkedList<T>();
	
	//Receive value for setting all four items
	public static void main(String[] args)
	{
		//String
		MyFour<String> note= new MyFour<String>();
		note.setNum();
		System.out.println(note.toString());
		note.equals();
		System.out.println(note.allEqual());
		//Int
		MyFour<Integer> note2= new MyFour<Integer>();
		note2.setNum();
		System.out.println(note2.toString());
		note2.equals();
		System.out.println(note2.allEqual());
		//shift
		note.shiftleft();
		System.out.println(note.toString());
		note2.shiftleft();
		System.out.println(note2.toString());
	}
	
	public void setNum()
	{
		Scanner sc=new Scanner(System.in);
		for(int i=0; i<4; i++)
		{
			System.out.print("item"+i+"=");
			item=(T)sc.next();
			list.add(item);
		}
	}
	
	public Boolean allEqual()
	{
		return condition;
	}
	
	public void equals()
	{
		if(list.get(0)==list.get(1) && list.get(1)==list.get(2) 
				&& list.get(2)==list.get(3) && list.get(4)==list.get(1))
			condition=true;
	}
	
	public void shiftleft()
	{
		T x=list.getFirst();
		list.removeFirst();
		list.addLast(x);
	}
	
	public String toString()
	{
		return "("+list.get(0)+","+list.get(1)+","+list.get(2)+","+list.get(3)+")";
	}
	
}
