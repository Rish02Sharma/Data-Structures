package Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class DFS {

    private LinkedList<Integer> graph[];
    private int V;
    //To create a graph
        DFS(int v){
            V = v;
            graph = new LinkedList[v];

            for(int i=0; i<v; i++){
                graph[i] = new LinkedList<>();
            }
        }

        public void addEdge(int v, int nv){
            graph[v].add(nv);
        }


        public void graphUtil(int v, boolean[] visited){
            visited[v] = true;
            System.out.println(v + " ");

            Queue<Integer> queue = new LinkedList<>();
            queue.add(v);

            Iterator<Integer> i = graph[v].listIterator();
            while(i.hasNext()){
                int n = i.next();

                if(!visited[n]){
                    graphUtil(n, visited);
                }
            }

        }


        public void graphBFS(int s){

            //First the boolean visited array
            boolean visited[] = new boolean[V];

            graphUtil(s, visited);
        }


    public static void main(String args[]){
        DFS g = new DFS(4);
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 

        System.out.println("Lets see the BFS Traversal output: ");

        g.graphBFS(2);

    }

}