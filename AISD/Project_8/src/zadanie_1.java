
public class zadanie_1 
{
	public static Boolean isHeap(int[] tablica)
	{
        for(int k=2;k<tablica.length;k++) 
        {
            if(tablica[k] > tablica[Math.floorDiv(k, 2)]) 
            {
                return false;
            }
        }
        return true;
	}
	public static void main(String[] args)
	{
		int[] tab = new int[] {0, 12, 3, 7, 11, 10, 8, 2, 10, 9, 15};
		//int[] tab = new int[] {0,15,14,12};
		//int[] tab = new int[] {0,15,15,12};
	        if(isHeap(tab)) 
	        {
	            System.out.println("Podana struktura jest kopcem.");
	        }
	        else 
	        {
	            System.out.println("Podana struktura nie jest kopcem.");
	        }
	}
}
