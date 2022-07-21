import java.io.*;
import java.util.*;
@SuppressWarnings("unchecked")

/**
 * Time Complexity:
O(V+E)

Because of the DFS approach.
 */

class Hamilt {
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
      
      // write all your codes here
      HashSet<Integer> vis = new HashSet<>();
      Hamiltonian(graph,src,vis,src+"",src);
   }
   
   
   public static void Hamiltonian(ArrayList<Edge>[] graph, int src, HashSet<Integer> vis,String path, int osrc){
      
      if(vis.size() == graph.length-1){
          System.out.print(path);
          boolean closeEdge = false;
          for(Edge e: graph[src]) //checking the nbrs of graph[6] if 0 is there as nbr or not!
          {
              if(e.nbr == osrc){ //original source
                  closeEdge = true;
                  break;
              }
          }
          
          if(closeEdge == true){
              System.out.println("*");
          }
          else{
              System.out.println(".");
          }
          
          return;
      }
      
      
      vis.add(src);
      
      for(Edge e : graph[src]){
          if(!vis.contains(e.nbr)){
              Hamiltonian(graph,e.nbr,vis,path+e.nbr,osrc);
              
          }
      }
      
      vis.remove(src);
      
      return;
      
      
   }


}

/**
 * Sample Input
7
9
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
2 5 10
0
Sample Output
0123456.
0123465.
0125643*
0346521*

 */