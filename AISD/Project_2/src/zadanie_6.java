import java.util.Random;

public class zadanie_6 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//Wygeneruj tablic� 30 liczb ca�kowitych z przedzia�u [-900, 1200), a nast�pnie wydrukuj powsta�� 
		//tablic�. Znajd� i wydrukuj element minimalny/maksymalny w tablicy.
		Random r = new Random(); 
		int[] tab=new int[30];
		int min=tab[0];
		int max=tab[0];
		System.out.print("Wy�wietlona tablica: ");
		for(int i=0;i<tab.length;i++)
		{
			tab[i]=r.nextInt(2100)-900;
			if(tab[i]>max)
			{
				max=tab[i];
			}
			if(tab[i]<min)
			{
				min=tab[i];
			}
		}
		for(int i=0;i<tab.length;i++)
		{
			System.out.print(" "+tab[i]+" ");
		}
		System.out.println();
		System.out.println("Element min: "+min);
		System.out.println("Element max: "+max);
	}

}
