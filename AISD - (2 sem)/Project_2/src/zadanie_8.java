import java.util.Random;
import java.util.Scanner;

public class zadanie_8 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//Wczytaj z klawiatury dwie liczby ca³kowite M i N. Wygeneruj tablicê/macierz o wymiarach MxN
		//liczb ca³kowitych z przedzia³u [-50,50) oraz wydrukuj j¹. Dokonaj transpozycji tej tablicy. 
		//Wydrukuj tablicê wynikow¹.
		Scanner in = new Scanner(System.in);
		System.out.print("Podaj iloœæ wierszy: ");
		int x=in.nextInt();
		System.out.print("Podaj iloœæ kolumn: ");
		int y=in.nextInt();
		Random r = new Random(); 
		int[][] tab=new int[x][y];
		System.out.println("Macierz: ");
		for(int i=0;i<x;i++)
		{
			for(int j=0;j<y;j++)
			{
				tab[i][j]=r.nextInt(100)-50;
				System.out.printf("%4d",tab[i][j]);
			}
			System.out.println();
		}
		System.out.println("Transpozycja macierzy: ");
		for(int i=0;i<y;i++)
		{
			for(int j=0;j<x;j++)
			{
			System.out.printf("%4d",tab[j][i]);
			}
			System.out.println();
		}
		
	}
}

