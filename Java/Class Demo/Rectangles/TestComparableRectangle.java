// Ozbirn, 08/23/17

public class TestComparableRectangle
{
   public static void main(String args[])
   {
      ComparableRectangle r1 = new ComparableRectangle(4,5);
      ComparableRectangle r2 = new ComparableRectangle(3,5);
      
      System.out.println("Rectangle r1 is: " + r1);
      System.out.println("Rectangle r2 is: " + r2);
      
      if (r1.compareTo(r2) < 0)
         System.out.println("r1 is smaller than r2");
      else if (r1.compareTo(r2) > 0)
         System.out.println("r1 is bigger than r2");
      else
         System.out.println("r1 is equal to r2");      
   }

}
