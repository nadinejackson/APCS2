public class QBoard
{
    private int[][] _board;
    private int _size;
    private int[] _banned;
    public QBoard(int size)
    {
	_board = new int[size][size];
	_size = size;
	_banned = new int[size];
	}
    public boolean add(int row, int col)
    {
	if (_board[row][col] != 0)
	    return false;
	_board[row][col] = 10;
        for (int r = 0; r < _board.length; r++)
            if (r != row)
                _board[r][col] += 1;
        for (int c = 0; c < _board[0].length; c++)
            if (c != col)
                _board[row][c] += 1;

        for (int i = 1; row + i < _board.length && col + i < _board[0].length; i++)
            _board[row + i][col + i] += 1;
        for (int i = 1; row + i < _board.length && col - i >= 0; i++)
            _board[row + i][col - i] += 1;
        for (int i = 1; row - i >= 0 && col + i < _board[0].length; i++)
            _board[row - i][col + i] += 1;
        for (int i = 1; row - i >= 0 && col - i >= 0; i++)
            _board[row - i][col - i] += 1;
	return true;
    }
    public boolean remove(int row, int col)
    {
	if (_board[row][col] < 10)
	    return false;
	_banned[row] = col + 1;
	_banned[row + 1] = 0;
	_board[row][col] = 0;
        for (int r = 0; r < _board.length; r++)
            if (r != row)
                _board[r][col] -= 1;
        for (int c = 0; c < _board[0].length; c++)
            if (c != col)
                _board[row][c] -= 1;

        for (int i = 1; row + i < _board.length && col + i < _board[0].length; i++)
            _board[row + i][col + i] -= 1;
        for (int i = 1; row + i < _board.length && col - i >= 0; i++)
            _board[row + i][col - i] -= 1;
        for (int i = 1; row - i >= 0 && col + i < _board[0].length; i++)
            _board[row - i][col + i] -= 1;
        for (int i = 1; row - i >= 0 && col - i >= 0; i++)
            _board[row - i][col - i] -= 1;
	return true;
    }
    public int[][] solve(int r)
    {
	if (r >= _board.length)
	    return _board;
	for(int c = _banned[r]; c < _board.length; c++)
	    {
		if (add(r, c))
		    return solve(r + 1);
	    }
	
	undo(r - 1);
	//System.out.println(print());
	return solve(r - 1);
    }
    public boolean undo(int r)
    {
	for (int c = 0; c < _board.length; c++)
	    if (_board[r][c] == 10)
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
