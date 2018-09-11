/*****************************************************
Nadine Jackson
APCS2 pd2
HW24b -- On the DLL
2018-03-24
 * class LList
 * Implements a linked list of DLLNodes, each containing String data
 *****************************************************/

public class LList implements List //your List interface must be in same dir
{ 

    //instance vars
    private DLLNode _head;
    private DLLNode _tail;
    private int _size;

    // constructor -- initializes instance vars
    public LList( )
    {
	_head = null; //at birth, a list has no elements
	_tail = null;
	_size = 0;
    }


    //--------------v  List interface methods  v--------------
    
    public boolean add( String newVal )
    {
	DLLNode tmp = new DLLNode( newVal, _head );
	_head = tmp;
	_size++;
	if (_size == 1)
	    _tail = tmp;
	return true;
    }

    //insert a node containing newVal at position index

    public void add( int index, String newVal )
    {
	if (index == 0)
	    add(newVal);	
	else
	    {
		DLLNode temp = new DLLNode(newVal, getNode(index-1).getNext());
		getNode(index - 1).setNext(temp);
		if (index == _size)
		    _tail = temp;
		_size += 1;
	    }
    }


    //remove node at pos index, return its cargo

    public String remove( int index )
    {
	String temp = get(index);
	if (index == 0)
	    _head = _head.getNext();
	else
	    {
		getNode(index - 1).setNext(getNode(index).getNext());
		if (getNode(index - 1).getNext() == null)
		    _tail = getNode(index - 1);
	    }
	_size -= 1;
	return temp;
    }
    
    public String get( int index )
    {
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	String retVal;
	

	//walk to desired node
	if (index < size / 2){
	    DLLNode tmp = _head; //create alias to head
	    for( int i=0; i < index; i++ )
		tmp = tmp.getNext();
	}
	else{
	    DLLNode tmp = _tail;
	    for( int i=size - 1; i > index; i--)
		tmp = tmp.getPrev();
	}

	//check target node's cargo hold
	retVal = tmp.getCargo();
	return retVal;
    }
    public DLLNode getNode( int index )
    {
	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	DLLNode retVal;
	

	//walk to desired node
	if (index < size / 2){
	    DLLNode tmp = _head; //create alias to head
	    for( int i=0; i < index; i++ )
		tmp = tmp.getNext();
	}
	else{
	    DLLNode tmp = _tail;
	    for( int i=size - 1; i > index; i--)
		tmp = tmp.getPrev();
	}

	//check target node's cargo hold
	retVal = tmp;
	return retVal;
    }


    public String set( int index, String newVal )
    {

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	DLLNode retVal;
	

	//walk to desired node
	if (index < size / 2){
	    DLLNode tmp = _head; //create alias to head
	    for( int i=0; i < index; i++ )
		tmp = tmp.getNext();
	}
	else{
	    DLLNode tmp = _tail;
	    for( int i=size - 1; i > index; i--)
		tmp = tmp.getPrev();
	}

	//store target node's cargo
	String oldVal = tmp.getCargo();

	//modify target node's cargo
	tmp.setCargo( newVal );

	return oldVal;
    }


    //return number of nodes in list
    public int size() { return _size; }
    
    //--------------^  List interface methods  ^--------------


    // override inherited toString
    public String toString()
    {
	String retStr = "NULL->HEAD-><-";
	DLLNode tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "-><-";
	    tmp = tmp.getNext();
	}
	retStr += "TAIL->NULL";
	return retStr;
    }


    //main method for testing
    public static void main( String[] args )
    {
	LList james = new LList();

	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("beat");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("a");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("need");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("I");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	System.out.println( "2nd item is: " + james.get(1) );

	james.set( 1, "got" );
	System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

	System.out.println( james );

	LList zombies = new LList();
	zombies.add("doge");
	zombies.add("are");
	zombies.add("barking");
	zombies.add("moo");
	zombies.add("near");
	zombies.add("my");
	zombies.add("and then the next is house");
	zombies.add("that's grate");
	
	System.out.println("***************************************");
	System.out.println("zombies now is: " + zombies);
	zombies.add(0, "she loves voltron");
	System.out.println("zombies now is (after adding at 0): " + zombies);
	zombies.add(5, "fiiive");
	System.out.println("zombies now is (after adding at 5): " + zombies);  
	zombies.add(zombies.size(), "lsat");
	System.out.println("zombies now is (after adding at the end): " + zombies);
	
	zombies.remove(0);
	System.out.println("zombies now is (after remove at 0): " + zombies);
	zombies.remove(6);
	System.out.println("zombies now is (after removing at 6): " + zombies);  
	zombies.remove(zombies.size() - 1);
	System.out.println("zombies now is (after removing the end): " + zombies);   
    }

}//end class LList


