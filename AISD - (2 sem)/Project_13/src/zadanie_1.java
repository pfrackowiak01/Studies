
public class zadanie_1 
{
	private static int M = 5;
	private static Node[] st = new Node[M];

	private static class Node 
	{
		private Integer key;
		private Integer val;
		private Node next;

		public Node(Integer k, Integer v, Node ne) 
		{
			key = k;
			val = v;
			this.next = ne;
		}
	}

	private static Integer hash(Integer k) 
	{
		return (11 * k % M);
	}

	public Integer get(Integer k) 
	{
		int i = hash(k);
		for (Node x = st[i]; x != null; x = x.next)
			if (k.equals(x.key)) 
			{
				return (Integer) x.val;
			}
		return null;
	}

	public void put(Integer k, Integer v) 
	{
		int i = hash(k);
		for (Node x = st[i]; x != null; x = x.next)
			if (k.equals(x.key)) 
			{
				x.val = v;
				return;
			}
		st[i] = new Node(k, v, st[i]);
	}
	public void delete(Integer k) 
	{
		int i = hash(k);
		for (Node x = st[i]; x != null; x = x.next) 
		{
			if(k.equals(x.key)) 
			{
				return;
			}
		}
	}

	public void print() 
	{
		for(int i=0;i<M;i++) 
		{
			System.out.print(i+": ");
			for (Node x=st[i]; x != null; x = x.next) 
			{
				System.out.print(x.key+", "+x.val+"; ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) 
	{
		zadanie_1 tablicaHashowana = new zadanie_1();
		tablicaHashowana.put(69, 69 * 10);
		tablicaHashowana.put(65, 65 * 10);
		tablicaHashowana.put(83, 83 * 10);
		tablicaHashowana.put(89, 89 * 10);
		tablicaHashowana.put(81, 81 * 10);
		tablicaHashowana.put(85, 85 * 10);
		tablicaHashowana.put(84, 84 * 10);
		tablicaHashowana.put(74, 74 * 10);
		tablicaHashowana.put(79, 79 * 10);
		tablicaHashowana.put(78, 78 * 10);
		tablicaHashowana.print();
		System.out.println("Wartosc klucza 81 wyniosi: " + tablicaHashowana.get(81));
	}

}
