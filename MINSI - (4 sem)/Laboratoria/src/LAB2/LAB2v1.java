package LAB2;
import java.util.Random;

public class LAB2v1 {
public static double Zmienne(double x1, double x2) 
{
	double funkcja;
	funkcja=-(x1*x1)-(x2-x2)+2;
	return funkcja;
}
public static int[] BinaryTab(int dlChrom)
{
	Random random =  new Random();
	int[] TabBin = new int[(dlChrom*2)];
	for(int i=0;i<dlChrom*2;i++)
	{
		TabBin[i] = random.nextInt(2); 
	}
	
	return TabBin;
}
public static int dec(int dlChrom, int[] TabBin, int pol)
{
	int[] TabDec = new int[dlChrom];
	int a = 0;
	if(pol == 1)
	{
		for(int i=0;i<dlChrom;i++)
		{
			TabDec[i]= TabBin[i];
			if(TabDec[i]==1)
			{
				a += Math.pow(2, dlChrom-i);
			}
		}
	}
	if(pol == 2)
	{
		for(int i=0;i<dlChrom;i++)
		{
			TabDec[i]= TabBin[i+dlChrom];
			if(TabDec[i]==1)
			{
				a += Math.pow(2, dlChrom-i);
			}
		}
	}
	return a;
}
public static void main(String[] args)
{
	int dol = -2;
	int gor = 2;
	int  d = 5;
	double x1;
	double x2;
	int[] TabBin;
	int dlChrom = (int) Math.ceil((Math.log(((gor-dol)*Math.pow(10,d))))/Math.log(2));
	
	while(true)
	{
		TabBin = BinaryTab(dlChrom);
		
		x1= dol + dec(dlChrom, TabBin, 1) * ((gor-dol)/(Math.pow(2,dlChrom)-1));
		x2= dol + dec(dlChrom, TabBin, 1) * ((gor-dol)/(Math.pow(2,dlChrom)-1));
		
		if(x1>= -2.0 && x1<= 2.0 && x2>= -2.0)
		{
			break;
		}	
	}
	double funkcja=Zmienne(x1,x2);
	System.out.println("x1 = " + x1 + "\nx2 = " + x2);
    System.out.println("f(x1,x2) = " + funkcja);
}

}
