
public class zadanie_7 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//Wyznacz i wydrukuj na ekranie sumê pierwszych 11 liczb – potêg dwójki
		int suma=0;
		int p2=2;
		for(int i=0;i<=10;i++)
		{
		suma+=Math.pow(p2, i);
		}
		System.out.println("suma pierwszych 11 potêg liczby 2: "+suma);
	}

}
