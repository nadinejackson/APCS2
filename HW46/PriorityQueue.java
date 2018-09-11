//Nadie Jackson
//APCS2 pd2
//HW46 -- Arr, There Be Priorities Here Matey
//2018-05-09

public interface PriorityQueue<T>
{
    public void add(T newVal);
    public boolean isEmpty();
    public T peekMin();
    public T removeMin();
}
