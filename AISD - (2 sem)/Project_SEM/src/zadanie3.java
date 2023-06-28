
public class zadanie3 
{
    static class Graph
    {
        int vertices;
        int matrix[][];
        public Graph(int vertex) 
        {
            this.vertices = vertex;
            matrix = new int[vertex][vertex];
        }
        public void addEdge(int source, int destination, int weight) 
        {
            matrix[source][destination]=weight;
            matrix[destination][source] = weight;
        }
        int getMinimumVertex(boolean [] mst, int [] key)
        {
            int minKey = Integer.MAX_VALUE;
            int vertex = -1;
            for (int i = 0; i <vertices ; i++) 
            {
                if(mst[i]==false && minKey>key[i])
                {
                    minKey = key[i];
                    vertex = i;
                }
            }
            return vertex;
        }
        public void dijkstra_GetMinDistancesv1(int sourceVertexv1, int destinationVertexv1)
        {
            boolean[] spt = new boolean[vertices];
            int [] distance = new int[vertices];
            int INFINITY = Integer.MAX_VALUE;
            for (int i = 0; i <vertices ; i++) 
            {
                distance[i] = INFINITY;
            }
            distance[sourceVertexv1] =0;
            for (int i = 1; i <vertices ; i++) 
            {
                int vertex_U = getMinimumVertex(spt, distance);
                spt[vertex_U] = true;
                for (int vertex_V = 0; vertex_V <vertices ; vertex_V++) 
                {
                    if(matrix[vertex_U][vertex_V]>0){
                        if(spt[vertex_V]==false && matrix[vertex_U][vertex_V]!=INFINITY)
                        {
                            int newKey =  matrix[vertex_U][vertex_V] + distance[vertex_U];
                            if(newKey<distance[vertex_V])
                             distance[vertex_V] = newKey;
                        }
                    }
                }
            }
            printDijkstrav1(sourceVertexv1,destinationVertexv1, distance);
        }
        public void dijkstra_GetMinDistancesv2(int sourceVertexv2, int destinationVertexv2)
        {
            boolean[] spt = new boolean[vertices];
            int [] distance = new int[vertices];
            int INFINITY = Integer.MAX_VALUE;
            for (int i = 0; i <vertices ; i++) 
            {
                distance[i] = INFINITY;
            }
            distance[sourceVertexv2] =0;
            for (int i = 1; i <vertices ; i++) 
            {
                int vertex_U = getMinimumVertex(spt, distance);
                spt[vertex_U] = true;
                for (int vertex_V = 0; vertex_V <vertices ; vertex_V++) 
                {
                    if(matrix[vertex_U][vertex_V]>0){
                        if(spt[vertex_V]==false && matrix[vertex_U][vertex_V]!=INFINITY)
                        {
                            int newKey =  matrix[vertex_U][vertex_V] + distance[vertex_U];
                            if(newKey<distance[vertex_V])
                             distance[vertex_V] = newKey;
                        }
                    }
                }
            }
            printDijkstrav2(sourceVertexv2,destinationVertexv2, distance);
        }
        public void dijkstra_GetMinDistancesv3(int sourceVertexv3, int destinationVertexFinal)
        {
            boolean[] spt = new boolean[vertices];
            int [] distance = new int[vertices];
            int INFINITY = Integer.MAX_VALUE;
            for (int i = 0; i <vertices ; i++) 
            {
                distance[i] = INFINITY;
            }
            distance[sourceVertexv3] =0;
            for (int i = 1; i <vertices ; i++) 
            {
                int vertex_U = getMinimumVertex(spt, distance);
                spt[vertex_U] = true;
                for (int vertex_V = 0; vertex_V <vertices ; vertex_V++) 
                {
                    if(matrix[vertex_U][vertex_V]>0){
                        if(spt[vertex_V]==false && matrix[vertex_U][vertex_V]!=INFINITY)
                        {
                            int newKey =  matrix[vertex_U][vertex_V] + distance[vertex_U];
                            if(newKey<distance[vertex_V])
                             distance[vertex_V] = newKey;
                        }
                    }
                }
            }
            printDijkstrav3(sourceVertexv3,destinationVertexFinal, distance);
        }

        public void printDijkstrav1(int sourceVertexv1,int destinationVertexv1,int [] key)
        {
            System.out.println("Najkrótsza droga z z Seattle do El Paso przez Portland oraz Phoenix");
            System.out.println("Z Seattle: " + sourceVertexv1 + " do Portland: " +   + destinationVertexv1 +" dystans: " + key[destinationVertexv1]);
        }
        public void printDijkstrav2(int sourceVertexv2,int destinationVertexv2,int [] key)
        {
            System.out.println("Z Portland: " + sourceVertexv2 + " do Phoenix: " +   + destinationVertexv2 +" dystans: " + key[destinationVertexv2]);
        }
        public void printDijkstrav3(int sourceVertexv3,int destinationVertexFinal,int [] key)
        {
            System.out.println("Z Phoenix: " + sourceVertexv3 + " do El Paso: " +   + destinationVertexFinal +" dystans: " + key[destinationVertexFinal]);
        }
    }
    public static void main(String[] args) {
        int vertices = 20;
        Graph graph = new Graph(vertices);
        int sourceVertexv1 = 1;
        int sourceVertexv2 = 3;
        int sourceVertexv3 = 16;
        int destinationVertexv1 = 3;
        int destinationVertexv2 = 16;
        int destinationVertexFinal = 19;
        graph.addEdge(1, 2, 599);
		 graph.addEdge(1, 4, 497);
		 graph.addEdge(1, 3, 180);
		 graph.addEdge(2, 7, 420);
		 graph.addEdge(2, 8, 691);
		 graph.addEdge(3, 4, 432);
		 graph.addEdge(3, 5, 602);
		 graph.addEdge(4, 7, 345);
		 graph.addEdge(5, 6, 138);
		 graph.addEdge(5, 10, 291);
		 graph.addEdge(6, 7, 526);
		 graph.addEdge(7, 8, 440);
		 graph.addEdge(7, 12, 621);
		 graph.addEdge(7, 11, 432);
		 graph.addEdge(8, 9, 102);
		 graph.addEdge(9, 12, 452);
		 graph.addEdge(10, 11, 280);
		 graph.addEdge(10, 13, 114);
		 graph.addEdge(11, 14, 155);
		 graph.addEdge(11, 15, 108);
		 graph.addEdge(11, 16, 290);
		 graph.addEdge(12, 19, 268);
		 graph.addEdge(12, 15, 469);
		 graph.addEdge(13, 14, 138);
		 graph.addEdge(13, 16, 386);
		 graph.addEdge(13, 17, 118);
		 graph.addEdge(14, 15, 207);
		 graph.addEdge(16, 18, 116);
		 graph.addEdge(16, 19, 403);
		 graph.addEdge(17, 18, 425);
		 graph.addEdge(18, 19, 314);
        graph.dijkstra_GetMinDistancesv1(sourceVertexv1,destinationVertexv1);
        graph.dijkstra_GetMinDistancesv2(sourceVertexv2,destinationVertexv2);
        graph.dijkstra_GetMinDistancesv3(sourceVertexv3,destinationVertexFinal);
    }
}
