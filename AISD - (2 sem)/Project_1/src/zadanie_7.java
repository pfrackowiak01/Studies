
public class zadanie_7 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//Wyznacz i wydrukuj na ekranie sum� pierwszych 11 liczb � pot�g dw�jki
		int suma=0;
		int p2=2;
		for(int i=0;i<=10;i++)
		{
		suma+=Math.pow(p2, i);
		}
		System.out.println("suma pierwszych 11 pot�g liczby 2: "+suma);
	}

}
