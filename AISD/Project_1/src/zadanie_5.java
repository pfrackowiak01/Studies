import java.util.Scanner;

public class zadanie_5 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//Wczytaj dwie liczby naturalne z klawiatury. Wyznacz:
		//najwi�kszy wsp�lny dzielnik tych liczb (NWD),
		//najmniejsz� wsp�ln� wielokrotno�� tych liczb (NWW)
		Scanner in = new Scanner(System.in);
		System.out.println("Prosz� poda� liczb� a");
		double a = in.nextInt();
		System.out.println("Prosz� poda� liczb� b");
		double b = in.nextInt();
		double wynikNWD=NWD(a,b);
		double wynikNWW=NWW(a,b);
		System.out.println("NWD wynosi:"+wynikNWD);
		System.out.println("NWW wynosi:"+wynikNWW);
	}
	static double NWD(double a,double b)
	{
		double nd,r;
		while(b!=0)
		{
			r=a%b;
			a=b;
			b=r;
		}
		nd=a;
		return nd;
	}
	static double NWW(double a,double b)
	{
		double nw=(a*b)/NWD(a,b);
		return nw;
	}
}
