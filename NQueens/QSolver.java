public class QSolver
{
    public static String print(int[][] arr)
    {
	String ret = "";
	for (int i = 0; i < arr.length; i++){
	    for (int j = 0; j < arr[0].length; j++)
		ret += arr[i][j] + " ";
	    ret += "\n";
		}
	return ret;
    }
    public static int[][] solve()
    {
	int[][] board = new int[1][1];
	return solve(board, 0);
    }
    public static int[][] solve(int[][] board, int row)
    {
	if (row >= board.length)
	    return board;
	int[][] solution;
	for (int i = 0; i < board.length; i++)
	    if (board[row][i] == 0)
		if (canSolve(alter(board, row, i), row + 1))
		    {
			solution = solve(alter(board, row, i), row + 1);
			if (canSolve(solution, board.length - 1))
			    return solution;
			else
			    System.out.println(print(solution));
		    }
	for (int i = 0; i < board[0].length; i++)
	    board[board.length - 1][i] = 1;
	return board;
    }
    public static int[][] alter(int[][] board, int row, int col)
    {
	board[row][col] = 2;
	for (int r = 0; r < board.length; r++)
	    if (r != row)
		board[r][col] = 1;
	for (int c = 0; c < board[0].length; c++)
	    if (c != col)
		board[row][c] = 1;
	
	for (int i = 1; row + i < board.length && col + i < board[0].length; i++)
	    board[row + i][col + i] = 1;
	for (int i = 1; row + i < board.length && col - i >= 0; i++)
	    board[row + i][col - i] = 1;
	for (int i = 1; row - i >= 0 && col + i < board[0].length; i++)
	    board[row - i][col + i] = 1;
	for (int i = 1; row - i >= 0 && col - i >= 0; i++)
	    board[row - i][col - i] = 1;

	return board;
    }
    public static boolean canSolve(int[][] board, int row)
    {
	if (row >= board.length)
	    return true;
	for (int i = 0; i < board[row].length; i++)
	    if (board[row][i] == 0)
		return true;
	return false;
    }
    public static void main(String[] args)
    {
	System.out.println(print(solve()));
    }
}
