import java.io.*;
import java.util.*;
@SuppressWarnings("unchecked")

class IsConnected {
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
   
   public static boolean checkConnection(ArrayList<Edge>[] graph,int src, boolean[] vis){
       
       
       
    //   mark
        vis[src] = true;
        
        for(Edge edge: graph[src]){
            int nbr = edge.nbr;
            if(vis[nbr] == false){
                return checkConnection(graph,nbr,vis);
                
            }
        }
    
        return true;
   }
   
   public static boolean isConnected(ArrayList<Edge>[] graph){
       
       boolean[] vis = new boolean[graph.length];
       
       
    //   for(int v=0;v<graph.length;v++){
    //           ans = checkConnection(graph,v,vis);
    //           if(vis == false){
    //                 return false;   
    //           }
    //       }
    //   }
       
    //   return ans;
        boolean ans = checkConnection(graph,0,vis);
        for(int v=0;v<graph.length;v++)
            if(vis[v] == false){
                return false;
            }
        return ans;
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
      boolean ans = isConnected(graph);
      System.out.println(ans);
   }
}



/**
 * 7
8
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
true


2>>
7
5
0 1 10
2 3 10
4 5 10
5 6 10
4 6 10
false
 */