import java.util.Random;

public class zadanie_5 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//Wygeneruj tablicê 12 liczb rzeczywistych z przedzia³u [10, 50), a nastêpnie wydrukuj powsta³¹ 
		//tablicê. Odwróæ tablicê, tzn. przedstaw j¹ w odwrotnym porz¹dku i wydrukuj j¹
		Random r = new Random(); 
		int[] tab=new int[12];
		System.out.print("Wyœwietlona tablica: ");
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
