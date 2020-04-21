package Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    private LinkedList<Integer> graph[];
    private int V;
    //To create a graph
        BFS(int v){
            V = v;
            graph = new LinkedList[v];

            for(int i=0; i<v; i++){
                graph[i] = new LinkedList<>();
            }
        }

        public void addEdge(int v, int nv){
            graph[v].add(nv);
        }

        public void graphBFS(int s){

            //First the boolean visited array
            boolean visited[] = new boolean[V];

            //Second the queue which would help us iterate
            Queue<Integer> queue = new LinkedList<>();
            queue.add(s);
            visited[s] = true;
            

            while(!queue.isEmpty()){
                s = queue.poll();
                System.out.println(s + " ");

                Iterator<Integer> i = graph[s].listIterator();
                while(i.hasNext()){
                    int n = i.next();
                    if(!visited[n]){
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }

        }


    public static void main(String args[]){
        BFS g = new BFS(4);
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