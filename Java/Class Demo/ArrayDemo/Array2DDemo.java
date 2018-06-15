
public class Array2DDemo
{
   public static void main(String args[])
   {
      char arr[][] = new char[10][10];
      
      for (int i=0; i<10; i++)
         for (int j=0; j<10; j++)
            if (i == j || i == arr.length - 1 - j)
               arr[i][j] = 'X';
            else
               arr[i][j] = ' ';
               
      for (int i=0; i<10; i++)
      {
         for (int j=0; j<10; j++)
            System.out.print(arr[i][j]);
         System.out.println();
      }
   }
}