import java.util.Scanner;
public class zadanie_9 {

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		// TODO Auto-generated method stub
		//Wczytaj z klawiatury 6 liczb ca�kowitych i zapisz je w strukturze tablicy. 
		//Wydrukuj powsta�� tablic�.
		int[] tab=new int[6];
		for(int i=0;i<6;i++)
		{
			System.out.println("Prosz� poda� liczbe");
			tab[i]= in.nextInt();
		}
		for(int i=0;i<6;i++)
		{
			System.out.print( tab[i]+", ");
		}
	}

}
