//Nadie Jackson
//APCS2 pd2
//HW34 -- The English Do Not Wait In Line For Soup or Anything Else; They "Queue Up"
//2018-04-15

public class NodeQueue<Quasar> implements Queue<Quasar>
{
    private LLNode<Quasar> _front;
    private LLNode<Quasar> _back;
    private int _length;
    public NodeQueue()
    {
	_length = 0;
    }
    
    
    //means of removing an element from collection:
    //Dequeues and returns the first element of the queue.
    public Quasar dequeue()
    {
	if (_length != 0)
	    {
		Quasar retVal = _front.getValue();
		_front = _front.getNext();
		_length -= 1;
		return retVal;
	    }
	else
	    {
		return null;
	    }
	
    }

    //means of adding an element to collection:
    //Enqueue an element onto the back of this queue.
    public void enqueue( Quasar x )
    {
	LLNode<Quasar> wait = new LLNode<Quasar>(x, null);
	if (_length == 0)
	    {
		_front = wait;
		_back = wait;
	    }
	else
	    {
		_back.setNext(wait);
		_back = _back.getNext();
	    }
	_length += 1;
    }

    //Returns true if this queue is empty, otherwise returns false.
    public boolean isEmpty()
    {
	return _length == 0;
    }

    //Returns the first element of the queue without dequeuing it.
    public Quasar peekFront()
    {
	return _front.getValue();
    }

    public static void main(String[] args)
    {
	NodeQueue<String> test = new NodeQueue<String>();
	System.out.println(test.isEmpty());
	test.enqueue("Attention");
	test.enqueue("Finesse");
	test.enqueue("New Rules x Are You That Somebody?");
	test.enqueue("Havana");
	test.enqueue("Perfect");
	test.enqueue("Stay");
	test.enqueue("Feel It Still");
	test.enqueue("Despacito x Shape of You");
	test.enqueue("Issues");
	test.enqueue("Praying");
	test.enqueue("Sorry Not Sorry");
	System.out.println(test.peekFront());
	while(! test.isEmpty())
	    System.out.println(test.dequeue());
	
    }

}
