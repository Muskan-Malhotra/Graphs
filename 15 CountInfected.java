import java.io.*;
import java.util.*;
@SuppressWarnings("unchecked")

/**
 * Time Complexity:
We are simply doing a BFS traversal, hence the time complexity will be O(N + E) where N = number of vertices in the graph and E = number of edges in the graph.

Space Complexity:
To perform BFS, we use queue data structure, which will take O(N) auxiliary space.Please note that we are not taking into account the space taken to build the adjacency list, as it was given to us as an input.
 */


class CI {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
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
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());
      int t = Integer.parseInt(br.readLine());
      
      // write your code here
      boolean[] vis = new boolean[vtces];
      int count = 0;
      int tm = infection(graph,vis,src,t,count);
      System.out.print(tm);
      
   }
   
   static class Pair{
       
       int v;
       int time;
       
       Pair(int v,int time){
           this.v = v;
           this.time = time;
       }
   }
   
   public static int infection(ArrayList<Edge>[] graph, boolean[] vis, int src, int tm, int count){
       
       ArrayDeque<Pair> q = new ArrayDeque<>();
       q.add(new Pair(src,1));
       
       while(q.size()>0){
           Pair rem = q.removeFirst();
           
           if(rem.time>tm){
               return count-1;
           }
           
           vis[rem.v] = true;
           count++;
           
           for(Edge e:graph[rem.v]){
               if(vis[e.nbr] == false)
                    q.add(new Pair(e.nbr, rem.time+1));
           }
       }
       
       return count;
       
   }

}