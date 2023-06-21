
public class zadanie_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stos<Integer> stosWartosci=new Stos<Integer>();//operandów/wartoœci
		Stos<Character> stosOperatorow=new Stos<Character>();//operatorów
		String wyrazenie = "(3+(7*(4-2))+(2*(3+8)))-1";//3+11*(4-2)+15*(3+8)-1
		//String wyrazenie = "2*3+6";
		//(3+(7(4-2))+(2(3+8)))-1
		String liczba="";
		Character spr,plus='+',minus='-',mnozenie='*',nawias=')',operator;
		Integer spr2, w1, w2, wynik;
			for(int i=0;i<wyrazenie.length();i++) {
				liczba="";
				spr=wyrazenie.charAt(i);
				if(Character.isDigit(spr)==true) {
					while(i<wyrazenie.length()) {
						spr=wyrazenie.charAt(i);
						if(Character.isDigit(spr)==true) {
						liczba+=spr;
						i++;
						}
						else {
							break;
						}
					}
					spr2=Integer.parseInt(liczba);
					stosWartosci.push(spr2);
				}
				if(spr.equals(plus)||spr.equals(minus)||spr.equals(mnozenie)) {
					stosOperatorow.push(spr);
				}
				if(spr.equals(nawias)) {
					w1=stosWartosci.pop();
					w2=stosWartosci.pop();
					operator=stosOperatorow.pop();
					if(operator.equals(plus)) {
						wynik=w1+w2;
						stosWartosci.push(wynik);
					}
					if(operator.equals(minus)) {
						wynik=w2-w1;
						stosWartosci.push(wynik);
					}
					if(operator.equals(mnozenie)) {
						wynik=w1*w2;
						stosWartosci.push(wynik);
					}
				}	
			}
			if(stosWartosci.size()>1) {
				do {
					w1=stosWartosci.pop();
					w2=stosWartosci.pop();
					operator=stosOperatorow.pop();
					if(operator.equals(plus)) {
						wynik=w1+w2;
						stosWartosci.push(wynik);
					}
					if(operator.equals(minus)) {
						wynik=w2-w1;
						stosWartosci.push(wynik);
					}
					if(operator.equals(mnozenie)) {
						wynik=w1*w2;
						stosWartosci.push(wynik);
					}
				}
				while(stosWartosci.size()>1);
			}
			System.out.println("Wynik dzia³ania:");
			stosWartosci.print();
	}

}
