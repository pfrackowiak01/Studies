import java.util.Random;

public class zadanie_5 
{
		//5. Skonstruuj listê jednokierunkow¹ 20 losowych liczb ca³kowitych z przedzia³u [10, 999). 
		//Zaimplementuj wybrane operacje na tej liœcie i wydrukuj rezultat wykonania ka¿dej operacji:
		//a. Wstaw na listê liczbê 1000 w miejsce przed pierwsz¹ napotkan¹ liczb¹ trzycyfrow¹
		//b. Usuñ pierwszy i ostatni element z listy z listy

	static class LinkedList 
	{
		Elementy pierw;
	    class Elementy 
	    {
	        int i;
	        Elementy next;
	        Elementy(int d)
	        {
	            i = d;
	            next = null;
	        }
	    }
	    void deleteNode(int k)
	    {
	    	Elementy temp = pierw, prev = null;
	        if (temp != null && temp.i == k) 
	        {
	        	pierw = temp.next; 
	            return;
	        }
	        while (temp != null && temp.i != k) 
	        {
	            prev = temp;
	            temp = temp.next;
	        }
	        if (temp == null)
	            return;
	        prev.next = temp.next;
	    }
	    public void push(int new_i)
	    {
	    	Elementy new_Elementy = new Elementy(new_i);
	        new_Elementy.next = pierw;
	        pierw = new_Elementy;
	    }
	    public void printList()
	    {
	    	Elementy tnode = pierw;
	        while (tnode != null) 
	        {
	            System.out.print(tnode.i + " ");
	            tnode = tnode.next;
	        }
	    }
	    public static void main(String[] args)
	    {
	    	Random r = new Random();
	        LinkedList first = new LinkedList();
	        for(int i=0;i<20;i++) 
	        {
	        	first.push(r.nextInt(999)+11);
	        }
	        System.out.println("Wygenerowana lista:");
	        first.printList();
	    }
	}
}