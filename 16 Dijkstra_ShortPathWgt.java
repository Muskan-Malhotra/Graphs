import java.io.*;
import java.util.*;
@SuppressWarnings("unchecked")

/**
 * Time Complexity:
This is an interesting analysis. The time complexity of Dijkstra's algorithm will be O(E + V logV) where V = number of vertices and E = number of edges.
This is because, we are iterating over all the edges once during the entire run of the algorithm
In each iteration, we are popping one node and pushing the unvisited neighbour nodes. Since the priority queue can contain all the vertices, the push or pop operation will be O(log V).
Hence the total time complexity will be O(E) + O(V) * O(log V) = O(E + V log V).
Note: You can argue that we might be having multiple Pairs having the same node's value. So, the maximum size of the priority queue will be not O(N) but O(E).
But, even if you replace log V with Log E (cost of one push/pop operation), then there will be no difference in the time complexity as:

O(E + VlogE) = O(E + Vlog(V^2)) = O(E + 2V logV) = O(E + V logV) only.
Space Complexity:
We are taking a priority queue of Pair nodes. Hence, the space complexity will be O(N) where N = maximum Pair nodes in the queue, which is equivalent to O(V).

Follow Up: O(h)

We applied the dijkstra's algorithm on an undirected weighted graph. Can you apply it on a directed weighted graph?
Dijkstra's algorithm gives the shortest path of all destination nodes from a single source node. To find the shortest path between all the pairs of vertices, we will have to run Dijkstra's algorithm with source nodes as {0, 1, 2, ... n-1} individually.
Please remember that the dijkstra's algorithm will not give correct results if there exists a negative weight cycle in the graph. Hence, either the graph should contain only positive edges or there must be no cycles with negative weight edges present for the dijkstra's algorithm to work.
 */

/**
 * Algo
 * Use of Priority Qu
 * Check which ngr has small wgt
 * Move to that nbr adding the removed vertex ngr along
 * 
 */

class SPWgt {
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
   
   public static class Pair implements Comparable<Pair>{
       
       int v;
       String psf;
       int wgt;
       
       Pair(int v,String psf, int wgt){
           this.v = v;
           this.psf = psf;
           this.wgt = wgt;
       }
       
       public int compareTo(Pair o){
           return this.wgt - o.wgt;
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

      int src = Integer.parseInt(br.readLine());
      // write your code here
      boolean[] vis = new boolean[vtces];
      
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      pq.add(new Pair(src,src+"",0));
      
      while(pq.size()>0){
          
          Pair rem = pq.remove();
          
          if(vis[rem.v] == true){
              continue;
          }
          
          vis[rem.v] = true;
          
          //work
          System.out.println(rem.v+" via "+rem.psf+" @ "+rem.wgt);
          
          for(Edge e: graph[rem.v]){
              if(vis[e.nbr] == false){
                  pq.add(new Pair(e.nbr, rem.psf+e.nbr, rem.wgt+e.wt));
              }
          }
      }
      
   }
}


/**
 * Input
 * 7
8
0 1 10
1 2 10
2 3 10
0 3 40
3 4 2
4 5 3
5 6 3  --> change this wgt to 6 it will change to the que pattern as wgt becomes same after 5 same levl 6 will be printed
4 6 8
0
 */