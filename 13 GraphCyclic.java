import java.io.*;
import java.util.*;
@SuppressWarnings("unchecked")
/**
 * Time Complexity:
We are doing a simple BFS traversal of the graph. Hence the time complexity will be O(N + E) where N = number of vertices and E = number of edges.

Space Complexity:
We are building a visited array and a parent array of size equal to the number of vertices. Also, we are taking the queue data structure to perform BFS traversal, which will store at max n nodes.
Hence, the total space complexity will be O(n + n + n) = O(n) only.
Please note that we are not taking into account the space taken to build the adjacency list, as it was given to us as an input.

Follow Up: O(h)

There are many methods of cycle detection in graphs, such as:

Cycle Detection in Undirected Graph Using DFS
Cycle Detection in Undirected Graph Using BFS
Cycle Detection in Undirected Graph Using DSU (Disjoint Set Union)
Cycle Detection in Directed Graph using DFS
Cycle Detection in Directed Graph using Graph Coloring
Cycle Detection in Directed Graph using Topological Sort (Kahn's Algorithm/BFS)
All these algorithms are different from each other, and can be used interchangeably depending upon the type of graph (directed/undirected) and the type of problem.
 */

class Cyclic {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

    static class Pair{
        int v;
        String psf;
        
        Pair(int v,String psf){
            this.v = v;
            this.psf = psf;
        }
    }
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      // write your code here
      boolean[] vis = new boolean[vtces];
      
      boolean ans = false;
      for(int i=0;i<graph.length;i++){
          if(vis[i] == false){
              
              ans = isCyclic(graph,vis,i);
              if(ans == true){
                  break;
              }
          }
      }
      System.out.println(ans);
   }
   
   public static boolean isCyclic(ArrayList<Edge>[] graph, boolean[] vis, int src){
    //   Pair p;
    //   for(Pair p : q){
    //       System.out.print(p.v+" "+p.psf);
    //       System.out.println();
    //   }
       ArrayDeque<Pair> q = new ArrayDeque<>();
       q.add(new Pair(src,src+""));
       
       while(q.size() >0){
           
           Pair rem = q.remove();
           
           //mark*
           
           if(vis[rem.v] == true){
               return true;
           }
           
           vis[rem.v] = true;
           
           //add nbr
           for(Edge e:graph[rem.v]){
               if(vis[e.nbr] == false){
                   q.add(new Pair(e.nbr,rem.psf+e.nbr));
               }
           }
       }
       return false;
   }
   
}


/**
 * Sample Input
7
6
0 1 10
1 2 10
2 3 10
3 4 10
4 5 10
5 6 10
Sample Output
false

 */