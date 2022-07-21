import java.io.*;
import java.util.*;

@SuppressWarnings("unchecked")
/**
 * Time Complexity:
O(V+E)

Because the DFS approach has been used.
 */
class PF {
   public static class Edge{
       int v;
       int nbr;
       
       Edge(int v, int nbr){
           this.v = v;
           this.nbr = nbr;
       }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());//vertices
      int k = Integer.parseInt(br.readLine());//edges
      
      ArrayList<Edge>[] graph = new ArrayList[n];
      for(int i=0;i<graph.length; i++){
          graph[i] = new ArrayList<>();
      }
      
      for(int e=0;e<k;e++){
          String edg = br.readLine();
          int v1 = Integer.parseInt(edg.split(" ")[0]);
          int v2 = Integer.parseInt(edg.split(" ")[1]);
          
          graph[v1].add(new Edge(v1,v2));
          graph[v2].add(new Edge(v2,v1));
      }
      
      // write your code here
      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      
      boolean[] vis = new boolean[n];
      for(int i=0;i<graph.length;i++){
          if(vis[i] == false)
          {
              ArrayList<Integer> ar = new ArrayList<>();
              dfs(graph,i,vis,ar);
              comps.add(ar);
              
          }
      }
    //   System.out.print(comps);
      int pair = 0;
      for(int i=0;i<comps.size();i++){
          for(int j=i+1;j<comps.size();j++){
              //should not start from 0 coz then it will be permutation
            int count = comps.get(i).size() * comps.get(j).size();
            pair += count;
              
              
          }
      }
      
      System.out.print(pair);
   }
   
   public static void dfs(ArrayList<Edge>[] graph,int src,  boolean[] vis, ArrayList<Integer> ar){
       
       vis[src] = true;
       
       ar.add(src);
       
       for(Edge edge:graph[src]){
           if(vis[edge.nbr] == false){
               dfs(graph,edge.nbr,vis,ar);
           }
       }
       return;
       
   }

}


/**
 * Sample Input
7
5
0 1
2 3
4 5
5 6
4 6
Sample Output
16

 */