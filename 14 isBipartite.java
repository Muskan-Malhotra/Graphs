import java.io.*;
import java.util.*;
@SuppressWarnings("unchecked")

/**
 * Time Complexity:
We are simply doing a BFS traversal of the entire graph, which will take O(N + E) time, where N = number of vertices, and E = number of edges.

Space Complexity:
We are using a queue data structure for the BFS traversal, which will store at max N vertices. Hence, the space complexity is O(N).
Please note that we are not taking into account the space taken to build the adjacency list, as it was given to us as an input.

Follow Up: O(h)
 */
class Bipartite {
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
       int lvl;
       
       Pair(int v, String psf, int lvl){
           this.v = v;
           this.psf = psf;
           this.lvl = lvl;
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
      int[] vis = new int[vtces];
      Arrays.fill(vis,-1);
      //going to all connected components
      for(int v=0;v<vtces;v++){
          if(vis[v] == -1)
            {
              boolean ans = isbipartite(graph,vis, v);
              if(ans == false){
                  System.out.println(false);
                  return;
              }
            }
      }
      
      System.out.println(true);
   }
   
   public static boolean isbipartite(ArrayList<Edge>[] graph, int[] vis, int src){
       
       ArrayDeque<Pair> q = new ArrayDeque<>();
       q.add(new Pair(src,src+"",0));
       while(q.size()>0){
           
           Pair rem = q.removeFirst();
           
           if(vis[rem.v] !=-1){
             //has cycle that is why in this if conditon
               if(rem.lvl != vis[rem.v]){
                 //odd cycle condition that level don't match
                   return false;
               }
           }
           else{
               vis[rem.v] = rem.lvl;
           }
           
           for(Edge e:graph[rem.v]){
                if(vis[e.nbr] == -1){
                    q.add(new Pair(e.nbr, rem.psf+e.nbr,rem.lvl+1));
                }
           }
       }
       return true;
       // if this is returned means is either acyclic or has even number of edges in cyclic graph.
       
       
   }
   
}



/**import java.io.*;

import java.util.*;

public class Main {
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
    ArrayList< Edge>[] graph = new ArrayList[vtces];
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

    HashMap< Integer, Integer> visited = new HashMap<>();
    for (int v = 0; v < vtces; v++) {
      if (!visited.containsKey(v)) {
        boolean bip = IsBipartite(graph, v, visited);
        if (!bip) {
          System.out.println(false);
          return;
        }
      }
    }

    System.out.println(true);
  }

  static class Pair {
    int vtx;
    int level;

    Pair(int vtx, int level) {
      this.vtx = vtx;
      this.level = level;
    }
  }

  public static boolean IsBipartite(ArrayList< Edge>[] graph,
                                    int src, HashMap< Integer, Integer> visited) {
    ArrayDeque< Pair> queue = new ArrayDeque<>();
    queue.add(new Pair(src, 0));
    while (queue.size() > 0) {
      Pair rem = queue.remove();

      if (visited.containsKey(rem.vtx)) {
        if (visited.get(rem.vtx) % 2 != rem.level % 2) {
          return false;
        }
      } else {
        visited.put(rem.vtx, rem.level);
      }

      for (Edge e : graph[rem.vtx]) {
        if (!visited.containsKey(e.nbr)) {
          queue.add(new Pair(e.nbr, rem.level + 1));
        }
      }
    }

    return true;
  }

}
*/