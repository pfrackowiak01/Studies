import java.util.Random;

public class zadanie_9 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//Wygeneruj dwie tablice o wymiarach o wymiarach 6x8 oraz 8x6 liczb ca³kowitych z przedzia³u 
		//[100,300) oraz wydrukuj je. Dokonaj przemno¿enia tych tablic/macierzy i wydrukuj wynik.
		Random r = new Random(); 
		int[][] tab1=new int[8][6];
		int[][] tab2=new int[6][8];
		int[][] tab3=new int[8][6];
		System.out.println("Wyœwietlona tablica 8 na 6: ");
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<6;j++)
			{
				tab1[i][j]=r.nextInt(200)+100;
				System.out.print(tab1[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("Wyœwietlona tablica 6 na 8: ");
		for(int i=0;i<6;i++)
		{
			for(int j=0;j<8;j++)
			{
				tab2[i][j]=r.nextInt(200)+100;
				System.out.print(tab2[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("Przemno¿enie na 8x6 ");
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<6;j++)
			{
				tab3[i][j]=tab1[i][j]*tab2[j][i];
				System.out.print(tab3[i][j]+" ");
			}
			System.out.println();
		}
	}

}
