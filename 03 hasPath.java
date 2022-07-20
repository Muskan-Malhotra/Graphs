import java.io.*;
import java.util.*;
@SuppressWarnings("unchecked")


/**
 * Time Complexity: O(V+E)
Where V is the number of vertices and E is the number of edges. In the worst case, all the vertices and all the edges will be travelled.

The time complexity of the while loop (k log(k)).Which sum up to O(n log(k)).

Space Complexity: O(V)
It will be the height of the recursion stack, which can be O(V) at max.
 */

class hasPath {

  public static class Edge{
    int src,nbr,wgt;

    Edge(){}
    Edge(int src,int nbr,int wgt){
      this.src = src;
      this.nbr = nbr;
      this.wgt = wgt;
    }
  }


  public static boolean hasP(ArrayList<Edge>[] graph,int src, int des, boolean[] vis){

    //self check
    if(src == des){
      return true;
    }

    //mark 
    vis[src] = true;

    //go to nbr
    //Method 1 to get the neighnour
    /**
     * for(int i=0;i<graph[src].size();i++){
      Edge edge = graph[src].get(i); //get the edge from the array graph arraylist
      int nbr = edge.nbr;

    }
     */

    //  Method 2
    for(Edge edge: graph[src]){  //graph of what type arraylist and arraylist has wahts? edge
      //edge is where? at the src provided i.e the vertex
      int nbr = edge.nbr;

      if(vis[nbr] ==  false)  // if the visited nbr is unvisited
      {  boolean hPNbr2Des = hasP(graph,nbr,des,vis);

        if(hPNbr2Des == true){
          return true;
        }}
    }
    return false;  // if src == des and nbr to des there is no path



  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int vertex = Integer.parseInt(br.readLine());
    
    ArrayList<Edge>[] graph = new ArrayList[vertex];
    for(int i=0;i<vertex;i++){
      graph[i] = new ArrayList<>();
    }

    int edges = Integer.parseInt(br.readLine());

    for(int e=0;e<edges;e++){
      String[] edg = br.readLine().split(" ");
      int v1 = Integer.parseInt(edg[0]);
      int v2 = Integer.parseInt(edg[1]);
      int wgt = Integer.parseInt(edg[2]);

      //Edges input taken from the user directly

      //adding the edges to the vertexes in the graph
      graph[v1].add(new Edge(v1, v2, wgt));
      graph[v2].add(new Edge(v2,v1,wgt));

    }
      int src = Integer.parseInt(br.readLine());
      int dest = Integer.parseInt(br.readLine());

      // write your code here
      boolean[] vis = new boolean[vertex];

      //w/o visited there will be an infinite loop b/w 0to1 and 1to0
      
      boolean ans = hasP(graph,src,dest, vis);
      System.out.println(ans);


  }
}

//input
/** 
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