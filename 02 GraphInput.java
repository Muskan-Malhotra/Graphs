import java.io.*;
import java.util.*;
@SuppressWarnings("unchecked")

class GraphInput {

  public static class Edge{
    int src,nbr,wgt;

    Edge(){}
    Edge(int src,int nbr,int wgt){
      this.src = src;
      this.nbr = nbr;
      this.wgt = wgt;
    }
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


  }
}