import java.util.Scanner;

public class zadanie_3 
{
	public static void main(String[] args) {
	//Wczytuj z klawiatury liczby ca�kowite tak d�ugo, 
	//a� u�ytkownik poda liczb� 0. Nast�pnie wydrukuj
	//sum� i �redni� arytmetyczn� podanych liczb.
	Scanner in = new Scanner(System.in);
	System.out.println("Prosz� poda� liczb�");
	double liczba = in.nextInt();
	double suma=0;
	double s=0;
	while(liczba!=0) 
	{
		s++;
		suma=suma+liczba;
		liczba = in.nextInt();
	}
	double srednia=suma/s;
	System.out.println("suma wynosi: " + suma);
	System.out.println("�rednia wynosi: " + srednia);
	System.out.println("liczba powt�rze�: "+s);
	}
}