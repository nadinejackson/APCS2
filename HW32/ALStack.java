/*****************************************************
 * Nadie Jackson
 * APCS2 pd2
 * HW32 -- Leon Leonwood Stack
 * 2018-04-11
 * Implements a stack of PANCAKES using an encapsulated LinkedList
 *****************************************************/
import java.util.ArrayList;

public class ALStack<PANCAKE> implements Stack<PANCAKE>
{
    private  ArrayList<PANCAKE> _stack; //inner container 
    private int _stackSize; //marker of what's inside

    //constructor
    public ALStack()
    {
	_stack = new ArrayList();
	_stackSize = 0; 
    }

    //means of insertion
    public void push(PANCAKE p)
    {
	_stack.add( _stackSize, p);
	_stackSize++;
    }

    //means of removal
    public PANCAKE pop( )
    {
	_stackSize -= 1;
	return _stack.remove(_stackSize);
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
	return (_stack.get(_stack.size() - 1));
    }

    //main method for testing
    public static void main( String[] args )
    {
    }

}//end class ALStack
