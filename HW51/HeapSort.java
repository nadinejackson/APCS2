//Nadie Jackson
//APCS2 pd2
//HW51 -- Heaping Piles of Sordidness
//2018-05-20

public class HeapSort
{
    /*WHERE THE MAGIC HAPPENS*/
    public static int[] sort(int[] arr)
    {
	heapify(arr, 1);
	for(int i = arr.length - 1; i > 0; i--)
	    {
		removeMin(arr, i + 1);
	    }
	return arr;
    }
    //parent is floor (i - 1) / 2 (just a reminder to myself)
    
    /*HEAPIFICATION NECESSARY TO HEAP SORT*/
    private static void heapify(int[] arr, int i) //i made all of these private because why should other classes access them?
    {
	if(arr[i] < arr[(i - 1) / 2])//if child less than parent
	    {
		swapUp(arr, i);//swap 'em
		heapify(arr, (i - 1) / 2); //heapify up the tree
	    }
	if(i + 1 < arr.length) //then go to the right
	    heapify(arr, i + 1);
    }
    
    /*HELPER FXNS THAT SHOULD SMELL FAMILIAR*/
    private static void swapUp(int[] arr, int i)
    {
	int j = arr[i];
	arr[i] = arr[(i - 1) / 2];
	arr[(i - 1) / 2] = j;
    }
    private static int minChildPos(int[] arr, int pos, int part)
    {
        int left = 2 * pos + 1;
        int right = left + 1;
        if(left >= part)
	    return -1;
	if(right >= part)
	    return left;
	if(arr[left] < arr[right])
	    return left;
	return right;
    }
    private static int removeMin(int[] arr, int part)
    {
        int retVal = arr[0];
	int i = 0; //index of the one to be snipped
        while(minChildPos(arr, i, part) < part && minChildPos(arr, i, part) != -1)
            {
	        i = minChildPos(arr, i, part);
	        swapUp(arr, i);
            }
	if (arr[part - 1] != retVal) //in case it wasn't swapped with the rightmost leaf
	    {
		int b = 0;
		for(int a = i; a < part - 1; a++){
		    arr[a] = arr[a + 1];
		    b = a;
		    while(arr[(b - 1) / 2] > arr[b])
			swapUp(arr, b);
		}
		arr[part - 1] = retVal;
	    }
	return retVal;
    }
    private static void printArray(int[] arr)
    {
	System.out.println();
	System.out.print("[");
	for(int i: arr)
	    System.out.print(i + ", ");
	System.out.print("]\n");
    }
    public static void main(String[] args)
    {
	int[] test0 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        sort(test0);
	printArray(test0);
	int[] test1 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
	sort(test1);
	printArray(test1);
	int[] test2 = new int[18];
	for(int i = 0; i < 18; i++)
	    test2[i] = (int)(18 * Math.random());
	sort(test2);
	printArray(test2);
    }
}
