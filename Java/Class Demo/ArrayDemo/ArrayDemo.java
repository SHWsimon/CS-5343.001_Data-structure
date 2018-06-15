// Ozbirn, 08/28/17

public class ArrayDemo
{
   public static void main(String args[])
   {
      int arr[] = new int[5];
      
      arr[0] = 10;
      arr[1] = 15;
      arr[2] = 20;
      arr[3] = 25;
      arr[4] = 30;
   
      for (int i=0; i<5; i++)
         System.out.print(arr[i] + " ");
      System.out.println();
      
      for (int val : arr)
        System.out.print(val + " ");
      System.out.println();
   }      
}
