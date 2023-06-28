
public class zadanie_2 
{   
	public static void main(String[] args) 
	{
		KolejkaString kol = new KolejkaString();
		kol.enqueue("Górski");
		kol.enqueue("Dudek");
		kol.drukuj();
		System.out.println();
		kol.dequeue();
		kol.drukuj();
		kol.dequeue();
		kol.drukuj();
		System.out.println();
		kol.enqueue("Grzybek");
		kol.enqueue("Cichosz");
		kol.drukuj();
		System.out.println();
		kol.dequeue();
		kol.drukuj();
		System.out.println();
		kol.enqueue("Kasprowiak");
		kol.drukuj();
		System.out.println();
		kol.dequeue();
		kol.drukuj();
		kol.dequeue();
		System.out.println();
		kol.drukuj();
	}

}
