import java.util.Random;

public class zadanie_5 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//Wygeneruj tablic� 12 liczb rzeczywistych z przedzia�u [10, 50), a nast�pnie wydrukuj powsta�� 
		//tablic�. Odwr�� tablic�, tzn. przedstaw j� w odwrotnym porz�dku i wydrukuj j�
		Random r = new Random(); 
		int[] tab=new int[12];
		System.out.print("Wy�wietlona tablica: ");
		for(int i=0;i<tab.length;i++)
		{
			tab[i]=r.nextInt(40)+10;
		}
		for(int i=0;i<tab.length;i++)
		{
			System.out.print(tab[i]+" ");
		}
		System.out.println();
		System.out.print("Przestawiona tablica: ");
		for(int i=0;i<6;i++)
		{
			int p=tab[i];
			tab[i]=tab[11-i];
			tab[11-i]=p;
		}
		for(int i=0;i<tab.length;i++)
		{
			System.out.print(tab[i]+" ");
		}
	}

}
