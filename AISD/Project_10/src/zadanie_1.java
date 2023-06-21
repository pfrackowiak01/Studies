
public class zadanie_1 
{
	private static class ProduktyST 
	{
		private Node first;
		int n;
		private class Node 
		{
			private String nazwa;
			private Double cena;
			private Node next;
			Node(String na, Double ce, Node nx)
			{
				nazwa = na;
				cena = ce;
				next = nx;
			}
		}
		ProduktyST()
		{
			first = null;
			n=0;
		}
		public boolean contains(String na) 
		{ 
			return get(na) != null; 
		} 
		Double get(String na) 
		{
			for (Node x = first; x!= null; x = x.next) 
			{ 
				if(na.equals(x.nazwa)) 
				{
					return x.cena; 
				}
			} 
			return null;
		}
		void put(String na, Double ce) 
		{
			for (Node x = first; x != null; x = x.next) 
			{ 
				if(na.equals(x.nazwa)) 
				{ 
					x.cena= ce; 
					return; 
				} 
				
			} 
			first= new Node(na, ce, first); 
			n++; 
		}
		void delete(String na) 
		{
			first= delete(first, na);
		}
		public Node delete(Node x, String na) 
		{
			if(x == null) 
			{ 
			return null;
			}
			if(na.equals(x.nazwa)) 
			{
				n--;
				return x.next;
			}
			x.next= delete(x.next, na);
			return x;
		}
		public boolean isEmpty() 
		{
			return first == null;
		}
		void size()
		{
			System.out.println("rozmiar tablicy: "+n);
		}
		public void printST()
		{
			System.out.println("lista: ");
			for (Node x = first; x != null; x = x.next) 
			{ 
				System.out.println(x.nazwa+" "+x.cena);
			}
		}
		public String Max()
		{
			Double maxCena = first.cena;
			String maxNazwa = first.nazwa;
			for (Node x = first; x!=null; x=x.next)
			{
				if(x.cena > maxCena)
				{
					maxCena = x.cena;
					maxNazwa = x.nazwa;
				}
			}
			return maxNazwa;
		}
		public Double srednia() 
		{
			Double srednia=0.0;
			Double	suma=0.0;
			Integer iloscElementow = 0;
			for (Node x = first; x != null; x = x.next) 
			{
				suma+=x.cena;
				iloscElementow++;
			}
			srednia = suma / iloscElementow;
			return srednia;
		}
	}
	public static void main(String[] args) 
	{
		ProduktyST produkt = new ProduktyST();
		produkt.put("P01", 14.50);
		produkt.put("P05", 14.55);
		produkt.put("P06", 12.30);
		produkt.put("P02", 8.90);
		produkt.put("P04", 11.69);
		produkt.printST();
		produkt.size();
		System.out.println();
		produkt.put("P01", 15.50);
		produkt.printST();
		produkt.size();
		System.out.println();
		produkt.put("P11", 10.45);
		produkt.printST();
		produkt.size();
		System.out.println();
		produkt.delete("P01");
		produkt.printST();
		produkt.size();
		System.out.println();
		System.out.println("Najwiêksz¹ cenê ma produkt o nazwie: "+produkt.Max());
		System.out.println("Œrednia cena wynosi: "+String.format("%.2f", produkt.srednia()));
	}
}
