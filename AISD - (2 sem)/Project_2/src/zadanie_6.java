import java.util.Random;

public class zadanie_6 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//Wygeneruj tablicê 30 liczb ca³kowitych z przedzia³u [-900, 1200), a nastêpnie wydrukuj powsta³¹ 
		//tablicê. ZnajdŸ i wydrukuj element minimalny/maksymalny w tablicy.
		Random r = new Random(); 
		int[] tab=new int[30];
		int min=tab[0];
		int max=tab[0];
		System.out.print("Wyœwietlona tablica: ");
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
