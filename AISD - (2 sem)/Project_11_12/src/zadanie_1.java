
public class zadanie_1 
{
	public static class BST
	{
		private Node root = null;
		private class Node
		{
		private String klucz;
		private Integer wartosc;
		private Node left, right;
		
		/*public Node(String k, Integer w)
		{
			klucz =k;
			wartosc=w;
		}
		*/
		
		public Node(String k)
		{
			klucz =k;
			wartosc=1;
		}
		
		}
		
		public Integer get(String klucz)
		{
			Node x = root;
			while (x != null)
			{
			int cmp = klucz.compareTo(x.klucz);
			if (cmp < 0) 
				x = x.left;
			else if (cmp > 0) 
				x = x.right;
			else if (cmp == 0) 
				return x.wartosc;
			}
			return null;

		}
		/*
		public void put(String klucz, Integer wartosc) 
		{
			root = put(root, klucz, wartosc);
		}
		
		private Node put(Node x, String klucz, Integer wartosc)
		{
		if (x == null) 
		return new Node(klucz);
		int cmp = klucz.compareTo(x.klucz);
		if (cmp < 0)
		x.left = put(x.left, klucz, wartosc);
		else if (cmp > 0)
		x.right = put(x.right, klucz, wartosc);
		else
		x.wartosc= wartosc;
		return x;
		}
		*/
		public void put(String klucz) 
		{
			root = put(root, klucz);
		}
		private Node put(Node x, String klucz)
		{
		if (x == null) 
		return new Node(klucz);
		int cmp = klucz.compareTo(x.klucz);
		if (cmp < 0)
		x.left = put(x.left, klucz);
		else if (cmp > 0)
		x.right = put(x.right, klucz);
		else
		x.wartosc++;
		return x;
		}
		public void deleteMin()
		{ 
		root = deleteMin(root); 
		}
		
		private Node deleteMin(Node x)
		{
		if (x.left == null) return x.right;
		x.left = deleteMin(x.left);
		return x;
		}
		
		public String min() 
		{
			return min(root).klucz;
		}
			private Node min(Node x) 
			{ 
			if (x.left == null)
			return x; 
			else
			return min(x.left); 
			}
		
		public void delete(String klucz)
		{ 
			root = delete(root, klucz); 
		}
			private Node delete(Node x, String klucz) 
			{
			if (x == null) return null;
			int cmp = klucz.compareTo(x.klucz);
			if (cmp < 0) 
			x.left = delete(x.left, klucz);
			else if (cmp > 0) 
			x.right = delete(x.right, klucz);
			else {
			if (x.right == null) return x.left;
			if (x.left == null) return x.right;
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
			}
			return x;
			}
		public void print()
		{
			print(root);
		}
		public void print(Node x)
		{
			if(x==null)
				return;
			print(x.left);
			System.out.println(x.klucz+" "+x.wartosc);
			print(x.right);
		}
		public int size() 
		{
			return size(root);
		}

		int size(Node root) 
		{
			if (root == null) 
			{
				return 0;
			} else 
			{
				return (size(root.left) + 1 + size(root.right));
			}
		}
	}
	
	public static void main(String[] args) 
	{
		String tekst = "T E S T D R Z E W B S T";
		String[] znaki = tekst.split(" ");
		BST bst = new BST();
		for(int i=0; i<znaki.length; i++)
		{
			bst.put(znaki[i]);
		}
		bst.print();
		System.out.println();
		// podpunkt b
		System.out.println("Literka G wystepuje: " + bst.get("G") + " razy");
		System.out.println("Literka T wystepuje: " + bst.get("T") + " razy");
		System.out.println();
		// podpunkt c
		bst.delete("R");
		bst.print();
		System.out.println();
		// podpunkt d
		for (int i = 0; i < 4; i++) 
		{
		bst.put("K");
		}
		bst.print();
		System.out.println();
		// podpunkt e
		bst.deleteMin();
		bst.print();
	}
}
