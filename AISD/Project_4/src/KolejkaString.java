
public class KolejkaString 
{
        private Node first, last;

        private class Node
        {
            String item;
            Node next;
        }
        public boolean isEmpty() 
        {
            return first == null;

        }
        public void enqueue(String item) 
        {
            Node oldlast = last; 
            last=new Node();
            last.item = item;
            last.next = null;
            if (isEmpty()) first = last;
            else oldlast.next = last;
        }
        public String dequeue() 
        {
            String item = first.item;
            first = first.next;
            if (isEmpty()) last = null;
            return item;
        }
        void drukuj() 
        {
        	for(Node x=first; x!=null; x=x.next)
    		{
    			System.out.println(x.item);
    		}
        }
        public void pierwszy()
        {
        	System.out.println("pierwszy elemnet: "+first.item);
        }
        public void ostatni()
        {
        	System.out.println("ostatni element: "+last.item);
        }
        void zlicz_plcie()
        {
        	int m=0;
        	int k=0;
        	for(int i=1;i<=6;i++) 
        	{
                String elementListy = this.dequeue();
                if(elementListy.endsWith("a")) 
                {
                    k++;
                }
                else {
                    m++;
                }
            }
        	 System.out.println("Liczba kobiet: "+k);
             System.out.println("Liczba mê¿czyzn: "+m);
        }
}


