import java.util.Random;

public class zadanie_4 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		// Wygeneruj tablic� dwuwymiarow� 10x10 liczb ca�kowitych z przedzia�u [10, 40), a nast�pnie 
		//wydrukuj powsta�� tablic�. Wyzeruj elementy le��ce pod g��wn� przek�tn�, a nast�pnie 
		//wydrukuj zmienion� tablic�.

		Random r = new Random(); 
		int[][] tab=new int[10][10];
		System.out.println("Wy�wietlona tablica: ");
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				tab[i][j]=r.nextInt(40)+10;
				System.out.printf("%4d",tab[i][j]);
			}
			System.out.println();
		}
		System.out.println("Nowa tablica: ");
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				if(j<i)
				{
				tab[i][j]=0;
				System.out.printf("%4d",tab[i][j]);
				}
				else
				{
				System.out.printf("%4d",tab[i][j]);	
				}
			}
			System.out.println();
		}
	}
}