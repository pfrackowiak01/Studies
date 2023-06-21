import java.util.Random;
import java.util.Scanner;

public class zadanie_8 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//Wczytaj z klawiatury dwie liczby ca�kowite M i N. Wygeneruj tablic�/macierz o wymiarach MxN
		//liczb ca�kowitych z przedzia�u [-50,50) oraz wydrukuj j�. Dokonaj transpozycji tej tablicy. 
		//Wydrukuj tablic� wynikow�.
		Scanner in = new Scanner(System.in);
		System.out.print("Podaj ilo�� wierszy: ");
		int x=in.nextInt();
		System.out.print("Podaj ilo�� kolumn: ");
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

