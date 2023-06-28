
public class zadanie_2 {

	public static void main(String[] args) 
	{
		String wyrazenie= "29 166 2 - *";
		Stos<Integer> stWartosc= new Stos<Integer>();
		String[] wyrazenieONP = wyrazenie.split(" ");
		Character plus='+',minus='-',mnozenie='*',dzielenie='/',znak;
		Integer liczba, w1, w2, wynik;
		for(int i=0;i<wyrazenieONP.length;i++) 
		{
			System.out.println(wyrazenieONP[i]);
			String st=wyrazenieONP[i];
			//sprawdzenie czy jest liczba i konwersja
			if(st.matches("[0-9]*"))
			{
				liczba=Integer.parseInt(st);
				stWartosc.push(liczba);
			}
			znak=wyrazenieONP[i].charAt(0);
			if(znak.equals(plus)||znak.equals(minus)||znak.equals(mnozenie)||znak.equals(dzielenie))
			{
				w1=stWartosc.pop();
				w2=stWartosc.pop();
				if(znak.equals(plus)) 
				{
					wynik=w1+w2;
					stWartosc.push(wynik);
				}
				if(znak.equals(minus)) 
				{
					wynik=w2-w1;
					stWartosc.push(wynik);
				}
				if(znak.equals(mnozenie)) 
				{
					wynik=w1*w2;
					stWartosc.push(wynik);
				}
				if(znak.equals(dzielenie)) 
				{
					wynik=w2/w1;
					stWartosc.push(wynik);
				}
			}
		}
		System.out.println("Wynik dzia³ania");
		stWartosc.print();
		
	}
}


