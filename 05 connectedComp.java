import java.io.*;
import java.util.*;
@SuppressWarnings("unchecked")

/**
 * 
 * Algo:
 * Every vertex is a potential vert3ex for a connected component
 * If the vertex is not occupied by the root vertex then it a 2nd diconnected graph. becox vis is false for the verte3x
 * A void function with graph and comps Al of Al<Int> is provided as arguments
 * for loop for all vertexes
 * if !visited call the sungle connected comp function
 * Parameters, graph,vertex v, visited array and an empty AL for on the way up recursive insertion.
 * Becox AL and vis are reference datatypes hence whatever changes are made in function are actually reflected in real variables as well
 */



class connectedComp {
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
   
   public static void SingleConComps(ArrayList<Edge>[] graphs, ArrayList<Integer> list, boolean[] vis, int src){
       
       //self work
       list.add(src);
       
       //mark
       vis[src] = true;
       
       //go to nbr
       for(Edge edge:graphs[src]){
           if(vis[edge.nbr] == false)
                SingleConComps(graphs,list,vis,edge.nbr);
       }
     
   }
   
  
   
   
   public static void connectedComps(ArrayList<Edge>[] graphs, ArrayList<ArrayList<Integer>> comps){
       
       boolean[] vis = new boolean[graphs.length];
       for(int v=0;v<graphs.length;v++){
           if(vis[v] == false){
               ArrayList<Integer> scc = new ArrayList<>();
               SingleConComps(graphs,scc,vis,v);
               comps.add(scc);
           }
       }
       
    //   System.out.print(comps);
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

      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      
      // write your code here
    //   comps = getConComp(comps,graph);
    
    connectedComps(graph,comps);

      System.out.println(comps);
   }
}


/**
 * 7
5
0 1 10
2 3 10
4 5 10
5 6 10
4 6 10
 */