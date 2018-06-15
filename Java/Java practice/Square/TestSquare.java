public class TestSquare
{
	public static void main(String[] args)
	{
		Square s=new Square();
		s.setlen();
		System.out.println(s.getArea());
		s.getlen(20);
		System.out.println(s.getArea());
	}
}

