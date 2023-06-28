package Firma;

public class Samochody {

	public int iloscKM = 120;
	public int przejechaneKilometry = 0;
	public String producent = "Brak informacji";
	public String kategoria = "Brak informacji";
	public String stan = "Brak informacji";
	
	void drukujKategorie() { 
		if (iloscKM > 200) kategoria = "A";
		else if (iloscKM > 100) kategoria = "B";
		else kategoria = "C";
		System.out.println(kategoria);
	}
	
	void drukujStan() {
		if (przejechaneKilometry == 0) stan = "Nieu¿ywany";
		else stan = "U¿ywany";
		System.out.println(stan);
	}
	
	Samochody(){}
	Samochody(int KM, int Kilometry){
		iloscKM = KM;
		this.przejechaneKilometry = Kilometry;
	}
	
	@Override
	public String toString() { 
		return "Iloœæ Koni Mechanicznych: " + String.valueOf(iloscKM) + 
			   "\nKategoria Samochodu: " + drukujKategorie() + 
			   "\nStan U¿ytkowania: " + drukujStan();
	}
	
	public void przegl¹d() {
		System.out.println(">>> Specyfikacja przegl¹du pojazdu: <<<");
		System.out.println("Iloœæ Koni Mechanicznych: " + iloscKM);
		System.out.println("Kategoria Samochodu: ");
		drukujKategorie();
		System.out.println("\nStan U¿ytkowania: "); 
		drukujStan();
	}
	
	static void zróbTo(Samochody p) {
		String a = p.getClass().getGenericSuperclass().getTypeName();
		System.out.println("\n super: " + a);
		String aa = p.getClass().getTypeName();
		System.out.println(" klasa: " + aa);
		String[] x = aa.split(".");
		String klasa = x[1].toString();
		
		
		System.out.println("\n=================================");
		System.out.println("Specyfikacja przegl¹du dla " + klasa.toUpperCase());
		System.out.println("=================================");
		
		p.przegl¹d();
	/*
		if (aa.equals("Testy.Doro¿ki")) System.out.println((Doro¿ki)p).typ);
		else System.out.println((Samochody)p).typ);
	*/
	
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Pojazdy pojazd = new Pojazdy();
		Samochody samochód = new Samochody();
		//Doro¿ki doro¿ka = new Doro¿ki();
		
		//zróbTo(pojazd);
		zróbTo(samochód);

	}
}
