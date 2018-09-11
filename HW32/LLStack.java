/*****************************************************
 * Nadie Jackson
 * APCS2 pd2
 * HW32 -- Leon Leonwood Stack
 * 2018-04-11
 * Implements a stack of PANCAKES using an encapsulated LinkedList
 *****************************************************/
import java.util.LinkedList;

public class LLStack<PANCAKE> implements Stack<PANCAKE>
{
    private  LinkedList<PANCAKE> _stack;
    private int _stackSize; 

    //constructor
    public LLStack()
    {
	_stack = new LinkedList();
	_stackSize = 0; 
    }

    //means of insertion
    public void push(PANCAKE p)
    {
	_stack.add(p);
	_stackSize += 1;
    }

    //means of removal
    public PANCAKE pop( )
    {
	_stackSize -= 1;
	return _stack.removeLast();
    }

    //chk for emptiness
    public boolean isEmpty()
    {
	return _stackSize == 0;
    }

    //chk for fullness
    public boolean isFull()
    {
	return _stackSize == _stack.size();
    }

    public PANCAKE peek()
    {
	return (_stack.getLast());
    }

    //main method for testing
    public static void main( String[] args )
    {
    }

}//end class LLStack
