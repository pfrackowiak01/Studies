
public class zadanie_2 
{
	private static int M = 16;
    private static Integer []vals=(Integer[]) new Integer[M];
    private static Integer [] keys = (Integer[]) new Integer [M];

    public static int hash(Integer k) 
    {
        return 11*k % M;
    }
    public static Integer get(Integer key)
    {
        for(int i= hash(key); keys[i]!=null;i=(i+1)%M)
        if(key.equals(keys[i]))
        return vals[i];
        return null;
    }
    public static void put(Integer key, Integer val) 
    {
        int i;
        for (i =  hash(key); keys[i] != null; i=(i+1)%M)
        if (keys[i].equals(key)) 
        break; 
        keys[i] = key;
        vals[i] = val;
    }
    public static void printst() 
    {
        for(int i =0;i<M;i++) 
        {
         System.out.print(i +": ");
         System.out.print(keys[i] +","+ vals[i]+" ");
         System.out.println();
        }
    }
	
	public static void main(String[] args) 
	{
		put(69, 6910);
        put(65, 6510);
        put(85, 8510);
        put(58, 5810);
        put(78, 7810);
        put(76, 7610);
        put(45, 4510);
        put(46, 4610);
        put(61, 6110);
        put(59, 5910);
        put(77, 7710);
        printst();
        System.out.println(get(77));
	}

}
