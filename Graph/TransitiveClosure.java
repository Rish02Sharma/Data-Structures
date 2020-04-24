package Graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class TransitiveClosure {

    private LinkedList<Integer> graph[];
    private int V;
    //To create a graph
        TransitiveClosure(int v){
            V = v;
            graph = new LinkedList[v];

            for(int i=0; i<v; i++){
                graph[i] = new LinkedList<>();
            }
        }

        public void addEdge(int v, int nv){
            graph[v].add(nv);
        }


        public void graphUtil(int v, int j){
            m[v][j] = 1;

            Iterator<Integer> i = graph[j].listIterator();
            while(i.hasNext()){
                int n = i.next();
                if(m[v][n] == 0)
                graphUtil(v, n);
            }

        }

         //First the boolean emtyp matric
         int m[][] = new int[4][4];

        public void findMatrix(){


            for(int i=0; i<4; i++){
                for(int j=0; j<4; j++){
                    m[i][j] = 0;
                }
            }
           
            for(int i =0; i< 4; i++){
                graphUtil(i, i);
            }

            for(int i=0; i<4; i++){
                for(int j=0; j<4; j++){
                    System.out.print(m[i][j]);
                }
                System.out.println();
            }
        }
            

        //This can be done by kosaraju algo in O(V+E) time in which if we take DFS for the first time then it is said that last vertex in dfs is mother vertex
        //Check dfs for the last verted and see result

    public static void main(String args[]){
        TransitiveClosure g = new TransitiveClosure(4);
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3);

         g.findMatrix();
    }
}