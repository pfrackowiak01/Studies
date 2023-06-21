
public class zadanie_3 {

	public static void main(String[] args) 
	{
		KolejkaString kol = new KolejkaString();
		kol.enqueue("Micha³");
		kol.enqueue("Wiktor");
		kol.enqueue("Ala");
		kol.enqueue("Milena");
		kol.enqueue("Maciej");
		kol.enqueue("Martyna");
		kol.drukuj();
		System.out.println();
		kol.pierwszy();
		kol.ostatni();
		System.out.println();
		kol.zlicz_plcie();
	}

}
