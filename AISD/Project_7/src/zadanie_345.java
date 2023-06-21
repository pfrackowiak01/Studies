
public class zadanie_345 
{
private static Boolean czyLiczba(String wartosc)
{
	if(wartosc == null || wartosc.equals(""))
	{
		return false;
	}
	else
	{
		try 
		{
		Integer.parseInt(wartosc);
		return true;
		}
		catch(NumberFormatException e)
		{
			
		}
		return false;
	}
}
private static String InaP(String wyrazenie)
{
	String prefix="";
	String[] elementywyrazenie = wyrazenie.split(" ");
	Stos<Integer> stosWartosci = new Stos<Integer>();
    Stos<String> stosOperatorow = new Stos<String>();
    for(Integer i=0;i<elementywyrazenie.length;i++) {
        
        if(czyLiczba(elementywyrazenie[i])) {
            Integer liczba = Integer.parseInt(elementywyrazenie[i]);
            stosWartosci.push(liczba);
        }
        else {
            stosOperatorow.push(elementywyrazenie[i]);
        }
    }
    while(!stosWartosci.isEmpty()) {
        Integer liczbaZeStosu = stosWartosci.pop();
        prefix += liczbaZeStosu;
        prefix += " ";
    }
    while(!stosOperatorow.isEmpty()) {
        String operator = stosOperatorow.pop();
        prefix += operator;
        prefix += " ";
    }
    return prefix;
}
	
	public static void main(String[] args) 
	{
		String wyrazenie="43 + 2 * ( 4 * 5 ) - ( 20 / 4 )";
		 System.out.println("Postaæ infixowa: "+wyrazenie);
	     String prefix = InaP(wyrazenie);
	     System.out.println("Postaæ prefixowa: "+prefix);

	}

}
