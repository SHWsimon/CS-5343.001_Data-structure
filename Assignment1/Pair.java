public class Pair<T>
{
	private T message;
	public void set(T m)
	{
		message=m;
	}
	
	public void get()
	{
		System.out.println(message);
	}
	
	public static void main(String[] args)
	{
		Pair<String> pair= new Pair<>();
		//message 1
		pair.set("Alice");
		pair.get();
		//message 2
		pair.set("Simon");
		pair.get();
		//System.out.println(m1+" "+m2);
		
	}
	
}