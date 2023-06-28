
public class Kolejka<Item> 
{
	    private Node first, last;
	    private int queueSize = 0;

	    private class Node 
	    {
	        Item item;
	        Node next;
	    }

	    public boolean isEmpty() 
	    {
	        return first == null;
	    }

	    public void enqueue(Item item) 
	    {
	        Node oldlast = last;
	        last = new Node();
	        last.item = item;
	        last.next = null;
	        if (isEmpty())
	            first = last;
	        else
	            oldlast.next = last;
	        queueSize++;
	    }

	    public Item dequeue() 
	    {
	        Item item = first.item;
	        first = first.next;
	        if (isEmpty()) last = null;
	        queueSize--;
	        return item;
	    }
	    
	    public void showQueue() 
	    {
	        for(Node x=first; x!=null; x=x.next) 
	        {
	            System.out.println(x.item);
	        }
	        System.out.println("Iloœæ elementów w kolejce: "+this.size());
	    }
	    
	    public int size() 
	    {
	        return queueSize;
	    }
}

