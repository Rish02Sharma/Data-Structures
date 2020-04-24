package Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class MotherVertex {

    private LinkedList<Integer> graph[];
    private int V;
    //To create a graph
        MotherVertex(int v){
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

        public boolean checkMother(boolean visited[]){
            for(int i=0; i<V; i++){
                if(visited[i] == false)
                    return false;
            }
            return true;
        }

        public int findMother(){

            //First the boolean visited array
            
            int motherIndex = 0;

            for(int i =0; i< V; i++){
                boolean visited[] = new boolean[V];
                
                graphUtil(i, visited);

                boolean check = checkMother(visited);
                if(check)
                motherIndex = i;
            }

            return motherIndex;
        }

        //This can be done by kosaraju algo in O(V+E) time in which if we take DFS for the first time then it is said that last vertex in dfs is mother vertex
        //Check dfs for the last verted and see result

    public static void main(String args[]){
        MotherVertex g = new MotherVertex(7);
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 3); 
        g.addEdge(4, 1); 
        g.addEdge(6, 4); 
        g.addEdge(5, 6); 
        g.addEdge(5, 2); 
        g.addEdge(6, 0); 

        int index = g.findMother();
        System.out.println(index);
    }

}