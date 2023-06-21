
public class zadanie_2 
{
	static class element
	{
		int i;
		element next;
	}

	public static void main(String[] args) 
	{
		//Skonstruuj listê jednokierunkow¹ 3 liczb ca³kowitych 10, 100, 1000. Wydrukuj powsta³¹ listê.
		element first = new element();
		element second = new element();
		element three = new element();
		first.i=10;
		second.i=100;
		first.next=second;
		three.i=1000;
		second.next=three;
		for(element x=first; x!=null; x=x.next)
		{
			System.out.println(x.i);
		}
		
	}

}
