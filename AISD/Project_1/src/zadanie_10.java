import java.util.Random;

public class zadanie_10 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//Wygeneruj tablic� 12 liczb ca�kowitych z przedzia�u [0, 100), a nast�pnie wydrukuj powsta��
		//tablic�. Zlicz, ile jest liczb parzystych w tej tablicy, wydrukuj stosowny komunikat. 
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
		System.out.print("ilo�� liczb parzystych: "+pa);
	}
}
