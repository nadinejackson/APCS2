//Team Parable.com Nadie Jackson and Daniel Jiang
//APCS2 pd2
//HW46 -- Arr, There Be Priorities Here Matey
//2018-05-09

import java.util.ArrayList;

public class ArrayPriorityQueue<T> implements PriorityQueue<T>
{
    /*  I N S T A N C E   V A R S  */
    private ArrayList<T> _data;

    /* C O N S T R U C T O R */
    public ArrayPriorityQueue()
    {
	_data = new ArrayList();
    }

    /*  M E T H O D S ( T O   T H E   M A D N E S S ) */
    public void add(T newVal) //runtime O(1)
    {
	_data.add(newVal); //add the element to the end of the AL
    }
    public boolean isEmpty() //runtime O(1)
    {
	return _data.size() == 0;
    }
    public T peekMin() //runtime O(n)
    {
	T lowest = _data.get(0);
	for(int i = 1; i < _data.size(); i++)
	    if(((Comparable)_data.get(i)).compareTo(lowest) < 0)
		lowest = _data.get(i);
	return lowest;
    }
    public T removeMin() //runtime O(n)
    {
	T lowest = _data.get(0);
	int lowInd = 0;
	for(int i = 1; i < _data.size(); i++)
	    if(((Comparable)_data.get(i)).compareTo(lowest) < 0)
		{
		    lowest = _data.get(i);
		    lowInd = i;
		}
        return _data.remove(lowInd);	
    }
    public static void main(String[] args)
    {
	ArrayPriorityQueue<String> classTests = new ArrayPriorityQueue<String>();
	classTests.add("foo");
	classTests.add("moo");
	System.out.println(classTests.removeMin());//should print foo
	classTests.add("goo");
	classTests.add("hoo");
	classTests.add("doo");
	System.out.println(classTests.removeMin()); //should print doo
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
	PriorityQueue<String> bob = new ArrayPriorityQueue<String>();
	bob.add("boo");
	bob.add("foo");
	bob.add("goo");
	bob.add("lieu");
	System.out.println(bob.peekMin()); //should return boo
	System.out.println(bob.removeMin()); //should return boo
	System.out.println(bob.removeMin()); //should return foo
	bob.add("sue");
	bob.add("doo");
	bob.add("moo");
	System.out.println(bob.removeMin()); //should return doo
	System.out.println(bob.removeMin()); //should return goo
	System.out.println(bob.removeMin()); //should return lieu
	
    }
}
