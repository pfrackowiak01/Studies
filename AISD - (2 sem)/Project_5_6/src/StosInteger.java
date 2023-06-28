
public class StosInteger 
{
	private Node first = null;
	private int stackSize = 0;
	private class Node 
	{
		Integer item;
        Node next;
	}
	public boolean isEmpty() 
	{ 
	return first == null; 
	}
	public void push(Integer item) 
	{
	Node oldfirst = first;
	first = new Node();
	first.item = item;
	first.next = oldfirst;
	stackSize++;
	}
	public Integer pop() 
	{
	Integer item = first.item;
	first = first.next;
	stackSize--;
	return item;
	}
	public void showQueue() 
    {
        System.out.println("Iloœæ elementów w kolejce: "+this.size());
    }
    public int size() 
    {
        return stackSize;
    }
	 void print() 
     {
     	for(Node x=first; x!=null; x=x.next)
 		{
 			System.out.print(x.item);
 		}
     }
}
