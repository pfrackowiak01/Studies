
public class zadanie_6 
{
	private static class Samochod 
	{
		String nrRejestracyjny, marka, godzPrzybycia;

		Samochod(String nrr, String marka, String godzP) 
		{
			this.nrRejestracyjny = nrr;
			this.marka = marka;
			this.godzPrzybycia = godzP;
		}
		public String toString() 
		{
			return "numer rejestracyjny: " + this.nrRejestracyjny + ", marka: " + this.marka+", czas przybycia auta: "+this.godzPrzybycia;
		}
	}

	public static void main(String[] args) 
	{
		Kolejka<Samochod> kolejkaSamochodow = new Kolejka<Samochod>();
		int maxDlugoscKolejki, roznicaGodzin = 0, roznicaMinut = 0;
		kolejkaSamochodow.enqueue(new Samochod("GA12345", "Audi", "12:16"));
		kolejkaSamochodow.enqueue(new Samochod("GA45825", "Volvo", "12:30"));
		kolejkaSamochodow.enqueue(new Samochod("GA16186", "BMW", "12:48"));
		kolejkaSamochodow.enqueue(new Samochod("GA16189", "Peugeot", "13:11"));
		kolejkaSamochodow.enqueue(new Samochod("GA21681", "Mercedes", "13:34"));
		kolejkaSamochodow.showQueue();
		maxDlugoscKolejki = kolejkaSamochodow.size();
		int[] godziny = new int[maxDlugoscKolejki], minuty = new int[maxDlugoscKolejki];
		for (int i = 0; i < maxDlugoscKolejki; i++) {
			Samochod samochod = (Samochod) kolejkaSamochodow.dequeue();
			String[] czas = samochod.godzPrzybycia.split(":");
			int godzina = Integer.parseInt(czas[0]);
			int minuta = Integer.parseInt(czas[1]);
			godziny[i] = godzina;
			minuty[i] = minuta;
		}
		for(int n=godziny.length-1;n>=1;n--) {
			int n1 = n+1;
			roznicaGodzin = Math.abs(godziny[n] - godziny[n-1]);
			roznicaMinut = Math.abs(minuty[n] - minuty[n-1]);
			if(roznicaMinut > 60) {
				roznicaGodzin++;
				roznicaMinut-=60;
			}
			else {
				roznicaGodzin = 0;
			}
			System.out.println("Ró¿nica w przybyciu samochodów nr "+n+" i "+n1+" "+roznicaGodzin+" godzin i "+roznicaMinut+" minut");
		}
		
	}
}

