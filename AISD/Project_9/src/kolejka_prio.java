import java.util.GregorianCalendar;

public class kolejka_prio  
{
	private Pacjent[] pq;
	private int n;
	public static class Pacjent implements Comparable<Pacjent>
	{
		String imie;
		String nazwisko;
		GregorianCalendar dataUrodzenia;
		Pacjent(String im, String naz, GregorianCalendar d)
		{
			imie = im;
			nazwisko = naz;
			dataUrodzenia = d;
		}
		public int compareTo(Pacjent p)
		{
			return dataUrodzenia.compareTo(p.dataUrodzenia);
		}
		public String toString()
		{
			return imie+" "+nazwisko;
		}
	}
	public kolejka_prio(int kolejka_lenght)
	{
		pq = new Pacjent[kolejka_lenght + 1];
		n=0;
	}
	 private void swim(int k) 
	    {
	        while (k > 1 && pq[k / 2].compareTo(pq[k]) > 0) 
	        {
	            //kopiec[k / 2] < kopiec[k] to rozpisana funkcja less
	        	Pacjent a = pq[k];
	            //rozpisana funkcja exch
	        	pq[k] = pq[k / 2];
	        	pq[k / 2] = a;
	            k = k / 2;
	        }
	    }
	 public void insert(Pacjent x)
	    {
		 	pq[++n] = x;
	        swim(n);
	    }
	 void print()
	 {
		 System.out.println("Kolejka: ");
		 for(int i=1; i<pq.length; i++)
		 {
			 System.out.println(pq[i]);
		 }
	 }
	public static void main(String[] args) 
	{
		kolejka_prio kolejkaP = new kolejka_prio(10);
		kolejkaP.insert(new Pacjent("Jan", "Kowalski", new GregorianCalendar(1961,9,20)));
		kolejkaP.insert(new Pacjent("Wiktor", "Górski", new GregorianCalendar(1981,2,26)));
		kolejkaP.insert(new Pacjent("Micha³", "Dudek", new GregorianCalendar(1991,9,20)));
		kolejkaP.insert(new Pacjent("Jan", "Smalec", new GregorianCalendar(1992,3,9)));
		kolejkaP.insert(new Pacjent("Jan", "Smalec", new GregorianCalendar(1993,1,22)));
		kolejkaP.insert(new Pacjent("Jan", "Smalec", new GregorianCalendar(1994,5,21)));
		kolejkaP.insert(new Pacjent("Jan", "Smalec", new GregorianCalendar(1995,6,11)));
		kolejkaP.insert(new Pacjent("Jan", "Smalec", new GregorianCalendar(1996,8,12)));
		kolejkaP.insert(new Pacjent("Jan", "Smalec", new GregorianCalendar(1998,12,1)));
		kolejkaP.insert(new Pacjent("Jan", "Smalec", new GregorianCalendar(2004,2,11)));
		kolejkaP.print();
	}
}

