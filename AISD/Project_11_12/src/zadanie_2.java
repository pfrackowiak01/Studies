
public class zadanie_2 
{
	private static class BST 
	{

		private Node root;

		private class Node 
		{
			private String kod;
			private Double cena;
			private Node left, right;

			public Node(String k, Double c) 
			{
				kod = k;
				cena = c;
			}
		}

		public Double get(String String) {
			Node x = root;
			while (x != null) {
				int cmp = String.compareTo(x.kod);
				if (cmp < 0)
					x = x.left;
				else if (cmp > 0)
					x = x.right;
				else if (cmp == 0)
					return x.cena;
			}
			return 0.0;
		}

		public void put(String kod, Double cena) 
		{
			root = put(root, kod, cena);
		}

		private Node put(Node x, String kod, Double cena) 
		{

			if (x == null)
				return new Node(kod, cena);
			int cmp = kod.compareTo(x.kod);
			if (cmp < 0)
				x.left = put(x.left, kod, cena);
			else if (cmp > 0)
				x.right = put(x.right, kod, cena);
			else
				x.cena++;
			return x;
		}

		public void deleteMin() {
			root = deleteMin(root);
			
		}

		private Node deleteMin(Node x) {
			if (x.left == null)
				return x.right;
			x.left = deleteMin(x.left);
			return x;
		}

		public void delete(String kod) {
			root = delete(root, kod);
			
		}

		private Node delete(Node x, String kod) {
			if (x == null)
				return null;
			int cmp = kod.compareTo(x.kod);
			if (cmp < 0)
				x.left = delete(x.left, kod);
			else if (cmp > 0)
				x.right = delete(x.right, kod);
			else {
				if (x.right == null)
					return x.left;
				if (x.left == null)
					return x.right;
				Node t = x;
				x = min(t.right);
				x.right = deleteMin(t.right);
				x.left = t.left;
			}
			return x;
		}

		public String min() {
			return min(root).kod;
		}

		private Node min(Node x) {
			if (x.left == null)
				return x;
			else
				return min(x.left);
		}

		public void print() {
			print(root);
			System.out.println("Wielkosc drzewa wynosi: "+this.size());
			System.out.println();
		}

		public void print(Node x) {	
			if (x == null)
				return;
			print(x.left);
			System.out.println(x.kod + " " + x.cena);
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
            }
            else {
                return(size(root.left) + 1 + size(root.right));
            }
        }
	}
	public static void main(String[] args) 
	{
		BST produkty = new BST();
		produkty.put("P01",14.90);
		produkty.put("P07",27.10);
		produkty.put("P03",120.00);
		produkty.put("P02",31.80);
		produkty.put("P09",39.20);
		produkty.print();
		//a
		produkty.put("P03",99.90);
		produkty.print();
		//b
		produkty.put("P04",18.50);
		produkty.print();
		//c
		produkty.delete("P01");
		produkty.print();
	}

}
