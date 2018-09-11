/*****************************************************
Nadie Jackson
APCS2 pd2
HW36 -- Now Let's Consider You Lot at Fake Terry's
2018-04-17
* class RQueue
* A linked-list-based, randomized queue
* (a collection with FIIDKO property)
*
*       -------------------------------
*   end |  --->   Q U E U E   --->    | front
*       -------------------------------
*
*  linkages point opposite direction for O(1) en/dequeuing
*            N <- N <- ... <- N <- N
*      _end -^                     ^- _front
*
******************************************************/

public class RQueue<T> implements Queue<T>{
    //instance variables
    private LLNode<T> _front, _end;
    private int _size;

    // default constructor creates an empty queue
    public RQueue(){
	_size = 0;
    }//end default constructor

    public void enqueue( T enQVal ){
	LLNode<T> newVal = new LLNode<T>(enQVal, _end);
	_end = newVal;
	_size += 1;
	sample();
	System.out.println("end" + _end);
    }//end enqueue()

    // remove and return thing at front of queue
    // assume _queue ! empty
    public T dequeue(){
	if (isEmpty())
	    return null;
	T retVal = _front.getValue();
	_size -= 1;
        LLNode<T> prior = _end;
	if (_end == _front){
		_end = _end.getNext();
		sample();
		return retVal;
	    }
	while(_end.getNext() != _front){
		_end = _end.getNext();
	    }
	_end.setNext(_end.getNext().getNext());
	_end = prior;
	sample();
	return retVal;
    }//end dequeue()

    public T peekFront(){
	return _front.getValue();
    }


    /******************************************
     * void sample() -- a means of "shuffling" the queue
     * Algo:
     * 1) pick a random index less than the size of the list
     * 2) make a temporary storage variable at end of list
     * 3) traverse through list to the index
     * 4) set front to the node at  that index
     ******************************************/
    public void sample(){
	int index = (int)(Math.random()*_size);
	LLNode<T> temp = _end;
	while(index > 0){
		temp = temp.getNext();
		index -= 1;
	}
	_front = temp;
    }//end sample()

    public boolean isEmpty() 
    {
	return _size == 0;
    } //O(1)

    // print each node, separated by spaces
    public String toString() 
    {
	LLNode<T> temp = _end;
	String retVal = "";
	int index = _size;
	while(index > 1)
	    {
		retVal += temp.getValue().toString() + " ";
		temp = temp.getNext();
		index -= 1;
	    }
	retVal += temp.getValue().toString();
	return retVal;
    }//end toString()
    
    //main method for testing
    public static void main( String[] args ){
	  Queue<String> PirateQueue = new RQueue<String>();

	  System.out.println("\nnow enqueuing..."); 
	  PirateQueue.enqueue("Dread");
	  PirateQueue.enqueue("Pirate");
	  PirateQueue.enqueue("Robert");
	  PirateQueue.enqueue("Blackbeard");
	  PirateQueue.enqueue("Peter");
	  PirateQueue.enqueue("Stuyvesant");

	  System.out.println("\nnow testing toString()..."); 
	  System.out.println( PirateQueue ); //for testing toString()...

	  System.out.println("\nnow dequeuing..."); 
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  
	  System.out.println("\nnow dequeuing fr empty queue..."); 
	  System.out.println( PirateQueue.dequeue() );
    }//end main
}//end class RQueue
