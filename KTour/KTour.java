public class KTour
{
    private int[][] _board;
    private int _size;
    private int[] _banned;
    private int _row;
    private int _col;
    public KTour(int size)
    {
	_board = new int[size][size];
	_size = size;
	_banned = new int[size * size];
	}
    public boolean add(int mv)
    {
	if (_board[row][col] == 1)
	    return false;
	_board[row][col] = 1;
	return true;
    }
    public boolean remove(int row, int col)
    {
	if (_board[row][col] == 0)
	    return false;
	_banned[row][col] = 0;
	return true;
    }
    public int[][] solve(int m)
    {
	if (m >= _banned.length)
	    return _board;
	for(int mv = _banned[r]; mv < 8; mv++)
	    {
		if (add( mv))
		    return solve(m + 1);
	    }
	undo(m - 1);
	return solve(m - 1);
    }
    public boolean undo(int r)
    {
	for (int c = 0; c < _board.length; c++)
	    if (_board[r][c] == 1)
		return remove(r, c);
	return false;
    }
    public String print()
    {
        String ret = "";
        for (int i = 0; i < _board.length; i++){
            for (int j = 0; j < _board[0].length; j++){
                if (_board[i][j] == 10)
		    ret += "Q ";
		else
		    ret += "- ";
	    }
            ret += "\n";
                }
        return ret;
    }

    public static void main(String[] args)
    {
	QBoard b9 = new QBoard(9);
	b9.solve(0);
	System.out.println(b9.print());
    }
}
