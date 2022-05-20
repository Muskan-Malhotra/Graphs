import java.util.*;

/**
 * Construction of the Graph is based in neighbours
 * Array is used to add vertices, coz they are constant
 * Arraylist of edeges helps to store edge with weight(10-20@20)
 * Arraylist<Edge> is saved in array []graph
 * 
 */

class construction{

  public static class Edge{
    int src;
    int nbr;
    int wgt;

    Edge(){}

    Edge(int src1,int nbr1,int wgt1){
      this.src = src1;
      this.nbr = nbr1;
      this.wgt = wgt1;

      // jo value a rahi hain via new Edge(10,20,30); wo edge class mein uske references position mein add ho jayengi using this!!

    }
  }

  public static void addEdge(ArrayList<Edge>[] graphs,int v1,int v2, int wgt){

    Edge e1 = new Edge(v1,v2,wgt);
    Edge e2 = new Edge(v2,v1,wgt);
    //we have packed the src,nbr and wgt in a pair like 10-20@50

    //now add this pack in the array
    graphs[v1].add(e1);
    graphs[v2].add(e2);


    //coz an undirected graph i.e why 0-1 is also there and 1-0 is also there

    //without using public static in class a reference to the class is required

  }

  public static void display(ArrayList<Edge>[] graphs){
    //print the graph two loops are rewuired first for vertex and then the edges connected to that certex!!
    
    for(int v=0;v<graphs.length;v++){  //this is an array
      System.out.print(v+"-> ");
      for(int e=0;e<graphs[v].size();e++){  //this is the arraylist of an array that is why array[i] and the arraylist size of the edges
        
        Edge edge = graphs[v].get(e);
        //this code is to get the edges at vertex v that are stored
        //if two edges are connected to the vertex then 2 times the loop will run
        //ek complete edge uthayi then usmein se src and nbr and wgt nikal ke print kara diya uske elements ko!! ONLY ONE EDGE ke
        
        System.out.print(edge.src+"-"+edge.nbr+"@"+edge.wgt+" , ");;

      }
      System.out.println();

    }



  }
  public static void main(String[] args) {

    // Scanner scn = new Scanner(System.in);
    // int v = scn.nextInt();   //constant vertices
    int v = 7;

    @SuppressWarnings("unchecked")
    ArrayList<Edge>[] graphs = new ArrayList[v];   //this is array banane ke liye //with just ArrayList[v] the actual arraylist with address or reference is not added it is just a structure or space occupied by arraylist that is null--matlb arraylist hai hi nahi
    //this is array of arraylist 
    //as of now there is array which contains arraylist that contains null.
    //we need to fill arraylist coz it is a reference type

    //IMPPPPP : chahe array linkedlist ka ho yah arraylist ka toh sirf [] brackets should be used!
    for(int i=0;i<v;i++){
      graphs[i] = new ArrayList<>(); //yeh arraylist banane ke liye..yeh generic list ke liye hota hai <>
      //creates a new arraylist with indexes with some addresses and not null
    }

    addEdge(graphs,0,3,40);
    addEdge(graphs,0,1,10);
    addEdge(graphs,1,2,10);
    addEdge(graphs,3,2,10);
    addEdge(graphs,3,4,2);
    addEdge(graphs,4,5,3);
    addEdge(graphs,5,6,3);
    addEdge(graphs,4,6,6);

    display(graphs);

    // scn.close();
  
  }
}

// ouput
// 0-> 0-3@40 , 0-1@10 ,
// 1-> 1-0@10 , 1-2@10 ,
// 2-> 2-1@10 , 2-3@10 ,
// 3-> 3-0@40 , 3-2@10 , 3-4@2 ,
// 4-> 4-3@2 , 4-5@3 , 4-6@6 ,
// 5-> 5-4@3 , 5-6@3 ,
// 6-> 6-5@3 , 6-4@6 ,