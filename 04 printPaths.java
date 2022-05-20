import java.io.*;
import java.util.*;
@SuppressWarnings("unchecked")

class printPaths {
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
   
   public static void printPath(ArrayList<Edge>[] graphs,int src, int des, boolean[] vis,String asf){
       
       if(src == des){
           System.out.println(asf);
           return;
       }
       
       vis[src] = true;
       
       //gtn
       for(Edge edge:graphs[src]){
           int nbr = edge.nbr;
           
           if(vis[nbr] == false ){
               printPath(graphs,nbr,des,vis,asf+nbr);
              //  printPath(graphs,nbr,des,vis,asf+src); //toh 0 pehle add ho jayega and this means ki jisse aya hun usse next step 1 ke step mein add kadunga eg == 012 graph.
           }
           
       }
       
       vis[src] = false;

       //if visited not marked false then any number of paths can be printed, may be all as well...coz at the time of returninf to the previous ngbr, the recursion will move to the next ngr not marked true and so different paths will be printed.
       return;
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
      int dest = Integer.parseInt(br.readLine());

      // write all your codes here
      boolean[] vis = new boolean[vtces];
      printPath(graph,src,dest,vis,""+src);
   }


}
/**
 * 
7
8
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
0
6
 */