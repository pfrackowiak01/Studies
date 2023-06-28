import java.util.Scanner;

public class zadanie_3 
{
	public static void main(String[] args) {
	//Wczytuj z klawiatury liczby ca³kowite tak d³ugo, 
	//a¿ u¿ytkownik poda liczbê 0. Nastêpnie wydrukuj
	//sumê i œredni¹ arytmetyczn¹ podanych liczb.
	Scanner in = new Scanner(System.in);
	System.out.println("Proszê podaæ liczbê");
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
	System.out.println("œrednia wynosi: " + srednia);
	System.out.println("liczba powtórzeñ: "+s);
	}
}