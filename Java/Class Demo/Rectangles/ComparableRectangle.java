// Ozbirn, 08/23/17

public class ComparableRectangle implements Comparable<ComparableRectangle>
{
   public ComparableRectangle(int len, int w)
   {
      length = len;
      width = w;
   }

   public int getLength()
   {
      return length;
   }
   
   public int getWidth()
   {
      return width;
   }
   
   public void setLength(int len)
   {
      length = len;
   }
   
   public void setWidth(int w)
   {
      width = w;
   }
      
   public String toString()
   {
      return "[" + length + "," + width + "]";
   }

   public int compareTo(ComparableRectangle other)
   {
      if (length*width < other.length * other.width)
         return -1;
      else if (length*width > other.length * other.width)
         return 1;
      else
         return 0;
   }

   private int length;
   private int width;

}
