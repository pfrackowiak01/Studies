import java.util.Random;

public class zadanie_2 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//Wygeneruj tablic� 12 liczb rzeczywistych z przedzia�u [-100, 100), a nast�pnie wydrukuj powsta�� 
		//tablic�. Jakich liczb jest wi�cej w tablicy: dodatnich czy ujemnych? Wydrukuj stosowny komunikat.
		Random r = new Random(); 
		int[] tab=new int[12];
		int u=0;
		int d=0;
		System.out.print("Wy�wietlona tablica: ");
		for(int i=0;i<tab.length;i++)
		{
			tab[i]=r.nextInt(200)-100;
		}
		for(int i=0;i<tab.length;i++)
		{
			System.out.print(tab[i]+", ");
		}
		for(int i=0;i<tab.length;i++)
		{
			if(tab[i]>0) 
			{
				d++;
			}
			else if(tab[i]<0)
			{
				u++;
			}
		}
		System.out.println();
		System.out.println("liczb ujemnych: "+u);
		System.out.println("liczb dodatnich: "+d);
		if(d>u)
		{
			System.out.println("liczb dodatnich jest wi�cej.");
			
		}
		else if(d==u)
		{
			System.out.println("liczb jest po r�wno");
		}
		else
		{
			System.out.println("liczb ujemnych jest wi�cej.");
			
		}
	}

}
