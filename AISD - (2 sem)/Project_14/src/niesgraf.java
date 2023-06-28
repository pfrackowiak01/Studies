
public class niesgraf 
{
	private int v;
	private int[][] T;
	public niesgraf(int liczba_wierszy)
	{
		v = liczba_wierszy;
		T= new int[v][v];
	}
	public void dodajKrawedz(int x, int y) 
	{
		T[x][y] = 1;
		T[y][x] = 1;
	}
	/*
	public void pokazGraf() 
	{
		int start=0;
		for(int i=0;i<v;i++) 
		{
			for(int j=start;j<v;j++) 
			{
				if(T[i][j] == true) 
				{
					System.out.println(i+" <-> "+j);
				}
			}
			start++;
		}
	}
	*/
	public int stopienWierzcholka(int wierzcholek) 
	{
		int stopien = 0;
		for (int i = 0; i < v; i++) 
		{
			if (T[wierzcholek][i] == 1) 
			{
				stopien++;
			}
		}
		return stopien;
	}
	public int maxStopienWierzcholka() 
	{
		int maxStopien = 0, stopien = 0, maxWierzcholek=0;
		for(int i=0;i<v;i++) 
		{
			stopien = stopienWierzcholka(i);
			if(stopien > maxStopien) 
			{
				maxStopien = stopien;
				maxWierzcholek=i;
			}
		}
		return maxWierzcholek;
	}
	public void pokazSasiadow(int x) 
	{
		String wynik = "Sasiadem liczby " + x + " jest ";
		for (int i = 0; i < v; i++) 
		{
			if (T[x][i] == 1) 
			{
				wynik += i+", ";
			}
		}
		System.out.println(wynik);
	}
	public void pokazGraf() 
	{
		for( int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{
				System.out.print(T[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) 
	{
		niesgraf graf = new niesgraf(7);
		graf.dodajKrawedz(0, 1);
		graf.dodajKrawedz(0, 2);
		graf.dodajKrawedz(0, 5);
		graf.dodajKrawedz(0, 6);
		graf.dodajKrawedz(3, 4);
		graf.dodajKrawedz(3, 5);
		graf.dodajKrawedz(4, 5);
		graf.dodajKrawedz(4, 6);
		graf.pokazGraf();
		System.out.println("Stopien wierzcholka 5: "+graf.stopienWierzcholka(5));
		System.out.println("Najwiekszy stopien wierzcholka: "+graf.maxStopienWierzcholka());
		graf.pokazSasiadow(6);
	}
}
