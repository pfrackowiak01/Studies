import java.util.Random;
import java.util.Arrays;

public class zadanie_11 {

	public static void main(String[] args) 
	{
	// TODO Auto-generated method stub
	//Wygeneruj tablic� 30 liczb ca�kowitych z przedzia�u [10, 50), a nast�pnie wydrukuj powsta��
	//tablic�. Sprawd� czy liczba 31 wyst�puje w tablicy. Wydrukuj stosowny komunikat. Zastosuj algorytm:
		Random r = new Random(); 
		int[] tab=new int[30];
		for(int i=0;i<30;i++)
		{
			tab[i]=r.nextInt(40)+11;
		}
		Arrays.sort(tab);
		sek(tab);
		bin(tab);
	}
	public static void sek(int[] tab)
	{
		boolean s=false;
		for(int i=0;i<30;i++)
		{
			System.out.println(tab[i]);
			if(tab[i]==31)
			{
				s=true;
			}
		}
		System.out.println("wyszukiwanie sekwencyjne");
		if(s==true)
		{
			System.out.println("liczba 31 znajduje si� w tablicy");
		}
		else
		{
			System.out.println("liczba 31 nie znajduje si� w tablicy");
		}
	}
	public static void bin(int[] tab)
	{
		System.out.println("wyszukiwanie binarne");
		int mid=0;
		int first=0;
		int end=tab.length-1;
		while (first <= end) {
            mid = (int) Math.floor((first + end) / 2);
            if (tab[mid] < 31) 
            {
                first = mid + 1;
            } 
            else if (tab[mid] > 31) 
            {
                end = mid - 1;
            } 
            else if(tab[mid]==31)
            {
                System.out.println("liczba 31 znajduje si� w tablicy");
                break;
            }
            else
            {
            	System.out.println("liczba 31 nie znajduje si� w tablicy");
            	break;
            }
        }
		
	}
}
