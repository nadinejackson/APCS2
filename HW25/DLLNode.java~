/*****************************************************
Nadine Jackson
APCS2 pd2
HW24a -- On the DLL
2018-03-24
 * class DLLNode
 * Implements a doubly-linked node,
 * for use in lists and other collection classes.
 * Stores data of type String
 *****************************************************/

public class DLLNode 
{
    private String _cargo;    //cargo may only be of type String
    private DLLNode _nextNode, _prevNode; //pointers to next, prev DLLNodes

    //YOUR IMPLEMENTATION HERE...
    // constructor -- initializes instance vars
    public DLLNode( String value, DLLNode next ) {
	_cargo = value;
	_nextNode = next;
	_prevNode = null;
    }


    //--------------v  ACCESSORS  v--------------
    public String getCargo() { return _cargo; }

    public DLLNode getNext() { return _nextNode; }

    public DLLNode getPrev() { return _prevNode; }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public String setCargo( String newCargo ) {
	String foo = getCargo();
	_cargo = newCargo;
	return foo;
    }

    public DLLNode setNext( DLLNode newNext ) {
	DLLNode foo = getNext();
	_nextNode = newNext;
	if (newNext != null)
	    newNext.setPrev(this);
	return foo;
    }

    public DLLNode setPrev(DLLNode newPrev) {
        DLLNode foo = getPrev();
	_prevNode = newPrev;
	if (newPrev != null)
	    newPrev._nextNode = this;
	return foo;
    }
    //--------------^  MUTATORS  ^--------------

    
    // override inherited toString
    public String toString() { return _cargo.toString(); }


    //main method for testing
    public static void main( String[] args )
    {

	//Below is an exercise in creating a linked list...

	//Create a node
	DLLNode first = new DLLNode( "cat", null );

	//Create a new node after the first
	first.setNext( new DLLNode( "dog", null ) );

	//Create a third node after the second
	first.getNext().setNext( new DLLNode( "cow", null ) );

	System.out.println(first);

	
    }//end main

}//end class DLLNode
