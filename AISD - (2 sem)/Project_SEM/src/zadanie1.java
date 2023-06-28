import java.util.Random;
import java.io.File;
import java.io.FileWriter; 
import java.io.IOException;
public class zadanie1 
{
	public static void plik(int[] tab) 
	{
		File ob = new File("liczby.DAT");
		try {
			if (ob.createNewFile()) 
			{
				System.out.println("Plik z danymi: ");
			    System.out.println("Utworzono plik: " + ob.getName());
			} 
			else 
			{
				System.out.println("Plik z danymi: ");
			    System.out.println("Plik "+ ob.getName()+" juz istnieje.");
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		try {
		      FileWriter myWriter = new FileWriter("liczby.DAT");
				for(int i = 0;i < tab.length; i++)
				{
					myWriter.write(tab[i]+ "\n");
				}
		      myWriter.close();
		      System.out.println("Sukces dane zapisane");
		    } 
		catch (IOException e) 
		{
		e.printStackTrace();
		}
	}
	public static void plik_kop(int[] tab) 
	{
		File ob = new File("liczby_sort2.DAT");
		try {
			if (ob.createNewFile()) 
			{
				System.out.println("Plik z kopcowaniem: ");
			    System.out.println("Utworzono plik z danymi sortowania przez scalanie: " + ob.getName());
			} 
			else 
			{
				System.out.println("Plik z kopcowaniem: ");
			    System.out.println("Plik "+ ob.getName()+" juz istnieje.");
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		try {
		      FileWriter myWriter = new FileWriter("liczby_sort2.DAT");
				for(int i = 0;i < tab.length; i++)
				{
					myWriter.write(tab[i]+ "\n");
				}
		      myWriter.close();
		      System.out.println("Sukces dane zapisane");
		    } 
		catch (IOException e) 
		{
		e.printStackTrace();
		}
		
	}
	public static void plik_scal(int[] tab) 
	{
		File ob = new File("liczby_sort1.DAT");
		try {
			if (ob.createNewFile()) 
			{
				System.out.println("Plik ze scalaniem: ");
			    System.out.println("Utworzono plik z danymi sortowania przez kopcowanie: " + ob.getName());
			} 
			else 
			{
				System.out.println("Plik ze scalaniem: ");
			    System.out.println("Plik"+ ob.getName()+" juz istnieje.");
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		try {
		      FileWriter myWriter = new FileWriter("liczby_sort1.DAT");
				for(int i = 0;i < tab.length; i++)
				{
					myWriter.write(tab[i]+ "\n");
				}
		      myWriter.close();
		      System.out.println("Sukces dane zapisane");
		    } 
		catch (IOException e) 
		{
		e.printStackTrace();
		}
	}
	
	public static class scalanie
	{
	public static int[] extablica;
	public static void sort(int[] tab)
	{
		extablica = new int[tab.length];
		scalsort(tab, 0, tab.length-1);
	}
	public static void scalsort(int[] array,int left,int right)
	{
		if(left < right)
		{
			int mid= (left+right)/2;
			scalsort(array, left, mid);
			scalsort(array, mid+1, right);
			scal(array, left, mid, right);
		}
	}
	public static void scal(int[]array,int left,int mid,int right)
	{
		for(int i=left; i<=right;i++)
		{
			extablica[i]=array[i];
		}
		int finger1=left;
		int finger2=mid+1;
		int current=left;
		while(finger1<=mid && finger2<=right)
		{
			if(extablica[finger1]<=extablica[finger2])
			{
				array[current]= extablica[finger1];
				finger1++;
			}
			else
			{
				array[current]= extablica[finger2];
				finger2++;
			}
			current++;
		}
		while(finger1<=mid)
		{
			array[current]=extablica[finger1];
			current++;
			finger1++;
		}
	}
	
	}  
	public static class kopiec
	{
	public static void sort(int[] tab)
	{
		int n = tab.length;
		for(int i=n/2-1;i>=0;i--)
		{
			kopiec.Maxkopiec(tab, n , i);
		}
		for(int i=n-1;i>0;i--)
		{
			kopiec.swap(tab, 0 , i);
			kopiec.Maxkopiec(tab, --n, 0);
		}
	}
	public static void Maxkopiec(int[] array, int size, int indexRodzica)
	{
		int maxIndex = indexRodzica;
		int left = indexRodzica*2+1;
		int right = indexRodzica*2+2;
		if(left<size && array[left]>array[maxIndex])
		{
			maxIndex=left;
		}
		if(right<size && array[right]>array[maxIndex])
		{
			maxIndex=right;
		}
		if(maxIndex != indexRodzica)
		{
			kopiec.swap(array, maxIndex, indexRodzica);
			kopiec.Maxkopiec(array, size, maxIndex);
		}
	}
	public static void swap(int[] arr, int index1, int index2)
	{
		int temp=arr[index1];
		arr[index1]=arr[index2];
		arr[index2]=temp;
	}
	}
	public static void main(String[] args) 
	{
		System.currentTimeMillis();
		Random rnd = new Random();
		int[] tab= new int[200000];
		int[] kop= new int[200000];
		int[] sca= new int[200000];
		for(int i = 0;i < tab.length; i++)
		{
			tab[i]=rnd.nextInt(24100)+900;
		}
		plik(tab);
		System.out.println();
		for(int i = 0;i < kop.length; i++)
		{
			kop[i]=tab[i];
		}
		long start=System.currentTimeMillis();
		kopiec.sort(kop);
		long stop=System.currentTimeMillis();
		plik_kop(kop);
		System.out.println("Czas wykonania:"+(stop-start));
		System.out.println();
		for(int i = 0;i < sca.length; i++)
		{
			sca[i]=tab[i];
		}
		long start1=System.currentTimeMillis();
		scalanie.sort(sca);
		long stop1=System.currentTimeMillis();
		plik_scal(sca);
		System.out.println("Czas wykonania:"+(stop1-start1));
	}

}