
public class zadanie_2
{

	public static void main(String[] args) 
	{
		StosInteger sztos = new StosInteger();
		sztos.push(1);
		sztos.push(2);
		sztos.push(3);
		sztos.push(4);
		sztos.push(5);
		sztos.print();
		System.out.println();
		sztos.showQueue();
		sztos.push(2);
		sztos.push(4);
		System.out.println();
		sztos.print();
		sztos.showQueue();
		sztos.pop();
		sztos.pop();
		System.out.println();
		sztos.print();
		sztos.showQueue();
		sztos.push(6);
		sztos.push(8);
		System.out.println();
		sztos.print();
		sztos.showQueue();
		sztos.pop();
		sztos.pop();
		System.out.println();
		sztos.print();
		sztos.showQueue();
		
	}

}
