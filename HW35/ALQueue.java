//Team NQDQ -- Susan Lin and Nadine Jackson
//APCS2 pd2
//HW35 -- ...Nor Do Aussies
//2018-04-16
import java.util.ArrayList;
public class ALQueue<Quasar> implements Queue<Quasar>
{
    private ArrayList<Quasar> _list;
    private int _size;
    public ALQueue()
    {
	_list = new ArrayList<Quasar>();
	_size = 0;
    }
    public boolean isEmpty()
    {
	return _size == 0;
    }
    public void enqueue(Quasar x)
    {
	_list.add(x);
	_size += 1;
    }
    public Quasar dequeue()
    {
	_size -= 1;
	return _list.remove(0);
    }
    public Quasar peekFront()
    {
	return _list.get(0);
    }
    public static void main(String[] args)
    {
	Queue<String> test = new ALQueue<String>();
	
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
