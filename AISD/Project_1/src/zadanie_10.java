import java.util.Random;

public class zadanie_10 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//Wygeneruj tablicê 12 liczb ca³kowitych z przedzia³u [0, 100), a nastêpnie wydrukuj powsta³¹
		//tablicê. Zlicz, ile jest liczb parzystych w tej tablicy, wydrukuj stosowny komunikat. 
		Random r = new Random(); 
		int[] tab=new int[12];
		for(int i=0;i<12;i++)
		{
			tab[i]=r.nextInt(101);
		}
		int pa=0;
		for(int i=0;i<12;i++)
		{
			System.out.println(tab[i]);
			if(tab[i]%2==0)
			{
				pa++;
			}
		}
		System.out.print("iloœæ liczb parzystych: "+pa);
	}
}
