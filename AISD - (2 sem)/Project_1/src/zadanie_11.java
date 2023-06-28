import java.util.Random;
import java.util.Arrays;

public class zadanie_11 {

	public static void main(String[] args) 
	{
	// TODO Auto-generated method stub
	//Wygeneruj tablicê 30 liczb ca³kowitych z przedzia³u [10, 50), a nastêpnie wydrukuj powsta³¹
	//tablicê. SprawdŸ czy liczba 31 wystêpuje w tablicy. Wydrukuj stosowny komunikat. Zastosuj algorytm:
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
			System.out.println("liczba 31 znajduje siê w tablicy");
		}
		else
		{
			System.out.println("liczba 31 nie znajduje siê w tablicy");
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
                System.out.println("liczba 31 znajduje siê w tablicy");
                break;
            }
            else
            {
            	System.out.println("liczba 31 nie znajduje siê w tablicy");
            	break;
            }
        }
		
	}
}
