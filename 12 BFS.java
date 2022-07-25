import java.io.*;
import java.util.*;
@SuppressWarnings("unchecked")
/**
 * Time Complexity:
The adding and removing of elements from the queue takes O(1) time. Since we are traversing every vertex of the graph to print its breadth first traversal, the time taken will be O(n).

Space Complexity:
Since we have used a queue data structure, the space complexity of the above method is O(n)


 */
class BFS {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
   
   static class Pair{
       int v;
       String psf;
       
       Pair(int v, String psf){
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
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());

      // write your code here  
      
      boolean[] vis = new boolean[vtces];
      
      ArrayDeque<Pair> q = new ArrayDeque<>();
      q.add(new Pair(src,src+""));
      
      while(q.size() >0){
          //remove
          Pair rem = q.removeFirst();
          
          //important condition for printing unique pairs.
          if(vis[rem.v] == true){
              continue;
          }
          
          //MArk *
          vis[rem.v] = true;
          //Work/Print
          System.out.println(rem.v+"@"+rem.psf);
          
          //Add nbr
          for(Edge e : graph[rem.v]){
              if(vis[e.nbr] == false){
                  q.add(new Pair(e.nbr,rem.psf+e.nbr));
              }
          }
      }
      
   }
}

/**
 * Sample Input
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
2
Sample Output
2@2
1@21
3@23
0@210
4@234
5@2345
6@2346

 */