import java.util.Random;

public class zadanie_3 
{
	public static String abc = "ABCDE";
	static char[] kopiec = new char[abc.length() + 1];
    static public int n = 0;
    public static Boolean isHeap(char[] T) {
        for (int i = 1; i < T.length - 2 / 2; i++) 
        {
            if (2 * i < T.length) 
            { // Sprawdzanie istnienia lewego potomka
                if (T[i] < T[i * 2]) 
                { // Sprawdzanie poprawnosci
                    return false;
                } 
                else 
                {
                    return true;
                }
            }
            else if (2 * i + 1 <= T.length) 
            { // Sprawdzanie istnienia prawego potomka
                if (T[i] < T[i * 2 + 1]) 
                { // Sprawdzanie poprawnosci
                    return false;
                } else {
                	return true;
                }
            }
        }
        return true;
    }
    public static void wynurz(int k) 
    {
        while (k > 1 && kopiec[k / 2] < kopiec[k]) 
        {
            //kopiec[k / 2] < kopiec[k] to rozpisana funkcja less
            char a = kopiec[k];
            //rozpisana funkcja exch
            kopiec[k] = kopiec[k / 2];
            kopiec[k / 2] = a;
            k = k / 2;
        }
    }
    public static void wstaw(char x)
    {
        kopiec[++n] = x;
        wynurz(n);
    }
	public static void main(String[] args) 
	{
		Random r = new Random();
		char letter = abc.charAt(r.nextInt(abc.length()));
		for (int i = 0; i < abc.length(); i++) 
        {
            System.out.print(abc.charAt(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < abc.length(); i++) 
        {
            char z = abc.charAt(i);
            wstaw(z);
        }
        for (int i = 1; i < kopiec.length; i++) 
        {
            System.out.print(kopiec[i] + " ");
        }
        System.out.println();
        if (isHeap(kopiec)) 
        {
            System.out.println("Jest kopcem");
        } 
        else 
        {
            System.out.println("Nie jest kopcem");
        }
	}
}
