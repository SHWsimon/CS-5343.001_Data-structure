// Ozbirn, 08/23/17

public class Rectangle
{
   public Rectangle(int len, int w)
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

   private int length;
   private int width;
}
