public class RecursionB
{
	public static void main(String[] args) 
	{  
		int array[] = {1, 2, 3, 4, 5};
		int count=countOdds(array, 0, array.length-1);
		System.out.print("How many odd number in the array: ");
		System.out.println(count);
	} 
	
	public static int countOdds(int a[], int left, int right)
	{
	    int count = 0;
	    if(left <= right)
	    {
	        count+=countOdds(a, left + 1, right);
	        if(a[left] % 2 != 0)
	        {
	            count++;
	        }
	    }
	    return count;   
	}
}