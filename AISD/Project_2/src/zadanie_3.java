import java.util.Random;

public class zadanie_3 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Random r = new Random(); 
		int[][] tab=new int[8][8];
		System.out.println("Wyœwietlona tablica: ");
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				tab[i][j]=r.nextInt(40)+10;
				System.out.print(tab[i][j]+", ");
			}
			System.out.println();
		}
		System.out.println("Suma przek¹tnej: ");
		double suma=0;
		double sre=0;
		for(int i=0;i<8;i++)
		{	
		suma += tab[i][i];
		}
		System.out.println("Suma wynosi: "+ suma);
		sre=suma/8;
		System.out.println("Œrednia wynosi: "+ sre);
	}

}
