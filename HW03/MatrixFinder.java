//Team Rhombus Candy -- Puneet Johal, Nadine Jackson, Daniel Jiang
//APCS2 pd2
//HW03 -- I Am Still Searching
//2018-02-01

/*-----------------------------------------------------------
  This searching algorithm works by starting at the top right
  corner of the matrix (at row 0 column n, n being the length
  of the matrix) and then working it's way down the last values
  of each row and comparing the "num", or the number that you
  want to find with the values in the matrix. The next
  comparison will be with the value the next row down, until a
  value is found that is larger than the target number, in
  which case the comparisons will take place with the next
  lowest value within that row (the value to the left), until
  a value is found that is less than the target, and the process
  repeats until either a value is found or the search ends up
  outside the matrix.
  -----------------------------------------------------------*/

public class MatrixFinder
{
    public static String search(int num, int[][] matrix)
    {
	int row = 0;
	int col = matrix.length - 1;
	while (row < matrix.length && col >= 0)
	    {
		if(matrix[row][col] == num)
		    {
			return "(" + row + ", " + col + ")";
		    }
		else
		    {
			if (matrix[row][col] > num) //if current num > target, search row
			    {
				    col -= 1; //go left
			    }
			else //if current num < target, search col
			    {
				if(col == matrix.length-1 || matrix[row][col + 1] > num) // if num to right > num --> indexing
				    row += 1; //go down
				else
				    col += 1; //go right
			    }
		    }
	    }
	return "(-1, -1)";
    }

    public static void main(String[] args)
    {
       MatrixFinder ethel = new MatrixFinder();
       int[][] lucy = new int[3][3];
       lucy[0][0] = 1;
       lucy[0][1] = 2;
       lucy[0][2] = 5;
       lucy[1][0] = 3;
       lucy[1][1] = 6;
       lucy[1][2] = 7;
       lucy[2][0] = 4;
       lucy[2][1] = 7;
       lucy[2][2] = 9;

       String foo = "";
       for (int r = 0; r < lucy.length; r++){
         foo += "| ";
         for (int c = 0; c < lucy.length; c++){
           foo += lucy[r][c] + " ";
         }
         foo += "|\n";
       }

       
       System.out.println("Matrix:");
       System.out.println(foo);
       System.out.println("Searching for the value 4...");
       System.out.println(search(4,lucy) + "\n");
       System.out.println("Searching for the value 9...");
       System.out.println(ethel.search(9,lucy) + "\n");
       System.out.println("Searching for the value 8...");
       System.out.println(ethel.search(8,lucy) + "\n");
       System.out.println("Searching for the value 10...");
       System.out.println(ethel.search(10,lucy) + "\n");

       int[][] candy = {{1,3,4},{3,7,8},{5,12,15}};
       String boo = "";
       for (int r = 0; r < candy.length; r++){
         boo += "| ";
         for (int c = 0; c < candy.length; c++){
           boo += candy[r][c] + " ";
         }
         boo += "|\n";
       }

       System.out.println("Matrix:\n" + boo);
       System.out.println("Searching for the value 5...");
       System.out.println(search(5,candy) + "\n");
       System.out.println("Searching for the value 3...");
       System.out.println(search(3,candy) + "\n");
       System.out.println("Searching for the value 8...");
       System.out.println(search(8,candy) + "\n");
       System.out.println("Searching for the value 0...");
       System.out.println(search(0,candy) + "\n");

       int[][] fancy = {{4}};
       String moo = "";
       for (int r = 0; r < fancy.length; r++){
         moo += "| ";
         for (int c = 0; c < fancy.length; c++){
           moo += fancy[r][c] + " ";
         }
         moo += "|\n";
       }

       System.out.println("Matrix:\n" + moo);
       System.out.println("Searching for the value 4...");
       System.out.println(search(4,fancy) + "\n");
       System.out.println("Searching for the value 3...");
       System.out.println(search(3,fancy) + "\n");
       System.out.println("Searching for the value 8...");
       System.out.println(search(8,fancy) + "\n");
       System.out.println("Searching for the value 0...");
       System.out.println(search(0,fancy) + "\n");
       
    }
}
