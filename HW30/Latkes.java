/*****************************************************
 * Nadie Jackson
 * APCS2 pd2
 * HW30 -- Stacks on Stacks on Stacks on Stacks
 * 2018-04-09
 * class Latkes
 * Implements a stack of Strings using an encapsulated array
 *****************************************************/

public class Latkes
{
    //there was qaf traffic on this and it seems there's no reason to add items to the front besides to make the cafeteria analogy clearer, so, in this code, new elements are added to and "removed" from the end.
    private String[] _stack; //inner container 
    private int _stackSize; //marker of what's inside

    //constructor
    public Latkes( int size )
    {
	_stack = new String[size]; //the container only ever needs to be this big cause it has limits
	_stackSize = 0; //there isn't anything there
    }

    //means of insertion
    public void push( String s )
    {
	if (isFull())
	    return; //it's full, but probably shouldn't throw exception?
	_stack[_stackSize] = s; //put some new data on top
	_stackSize += 1; //the data is now part of stack
    }

    //means of removal
    public String pop( )
    {
	if(isEmpty())
	    return "This list is already empty inside.";
	_stackSize -= 1; //no reason to take out the element, just move the marker
	return _stack[_stackSize]; //what previously was there
    }

    //chk for emptiness
    public boolean isEmpty()
    {
	if(_stackSize == 0)
	    return true;
	return false;
    }

    //chk for fullness
    public boolean isFull()
    {
	if (_stackSize == _stack.length)
	    return true;
	return false;
    }


    //main method for testing
    public static void main( String[] args )
    {
  
	Latkes tastyStack = new Latkes(10);

	tastyStack.push("aoo");
	tastyStack.push("boo");
	tastyStack.push("coo");
	tastyStack.push("doo");
	tastyStack.push("eoo");
	tastyStack.push("foo");
	tastyStack.push("goo");
	tastyStack.push("hoo");
	tastyStack.push("ioo");
	tastyStack.push("joo");
	tastyStack.push("coocoo"); //these two shouldn't fit in the list right? unless you want to break the plate dispenser
	tastyStack.push("cachoo");

	//cachoo
	System.out.println( tastyStack.pop() );
	//coocoo
	System.out.println( tastyStack.pop() );
	//joo
	System.out.println( tastyStack.pop() );
	//ioo
	System.out.println( tastyStack.pop() );
	//hoo
	System.out.println( tastyStack.pop() );
	//goo
	System.out.println( tastyStack.pop() );
	//foo
	System.out.println( tastyStack.pop() );
	//eoo
	System.out.println( tastyStack.pop() );
	//doo
	System.out.println( tastyStack.pop() );
	//coo
	System.out.println( tastyStack.pop() );
	//boo
	System.out.println( tastyStack.pop() );
	//aoo
	System.out.println( tastyStack.pop() );

	//stack empty by now; SOP(null)
	System.out.println( tastyStack.pop() );
	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v    ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

    }//end main()

}//end class Latkes
