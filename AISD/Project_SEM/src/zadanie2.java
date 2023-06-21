
public class zadanie2 
{
	Node first;
	static int size=0;
	class Node 
	{
        int item;
        Node next;

        public Node(int it) 
        {
            item = it;
            next = null;
        }
    }
	
	public void push(int it)
    {
    	Node new_node = new Node(it);
    	new_node.next = first;
        first = new_node;
        size++;
    }
	
	public void append(int it)
	{
	    Node new_node = new Node(it);
	    if (first == null)
	    {
	    	first = new Node(it);
	    	size++;
	        return;
	    }
	    new_node.next = null;
	    Node last = first;
	    while (last.next != null)
	    last = last.next;
	    last.next = new_node;
	    size++;
	    return;
	}
	private void add(int ileLiczb) 
	{
        int d = 0, n = 0, i = 1, j = 1;
        while (n < ileLiczb) 
        {
            j = 1;
            d = 0;
            while (j <= i) 
            {
                if (i % j == 0)
                    d++;
                j++;
            }
            if (d == 2) 
            {
               append(i);
               n++;
            }
            i++;
        }
    }
	
	public void before_after(int it) 
	{
        Node before_node = null;
        Node after_node = null;
        Node NodeX = findNode(it);
        before_node = null;
        after_node = NodeX.next;
        for(Node x=first;x!=null;x=x.next) 
        {
            if(x.next == NodeX) 
            {
            	 before_node = x;
            }
        }
        System.out.println("Poprzedni: "+before_node.item);
        System.out.println("Nastêpny: "+after_node.item);
    }
    
    private Node findNode(int it) 
    {
        Node needNode = null;
        for(Node x=first;x!=null;x=x.next) 
        {
            if(x.item == it) 
            {
            	needNode = x;
            }
        }
        return needNode;
    }
    public void delMaxOne()
    {
    	Node maxOne = null;
        for(Node x=first;x!=null;x=x.next) 
        {
            if(x.item>0 && x.item<10) 
            {
            	maxOne = x;
            }
        }
        delNode(maxOne.item);
    }
    void delNode(int key)
    {
        Node temp = first, prev = null;
        if (temp != null && temp.item == key) 
        {
            first = temp.next;
            return;
        }
        while (temp != null && temp.item != key) 
        {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null)
            return;
        prev.next = temp.next;
    }
    
	public void printList()
    {
    	for(Node x=first; x!=null; x=x.next)
		{
			System.out.print(x.item+" ");
		}
    }
	public static void main(String[] args) 
	{
		zadanie2 list = new zadanie2();
		list.add(13);
		System.out.println("Lista 13 liczb pierwszych od 2.");
		list.printList();
		list.append(43);
		list.push(1);
		System.out.println();
		System.out.println("A) Lista z 1 na pocz¹tku i kolejn¹ liczb¹ pierwsz¹ na koñcu.");
		list.printList();
		System.out.println();
		System.out.println("B) Rozmiar listy: "+size+".");
		System.out.println();
		System.out.println("C) Element przed i po 23.");
		list.before_after(23);
		System.out.println();
		System.out.println("D) Usuwanie najwieksze liczby jednocyfrowej.");
		list.delMaxOne();
		list.printList();
	}

}
