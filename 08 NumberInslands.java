import java.io.*;
/**
 * Time Complexity:
O(4*n2)

O(4*n2) which is simply written as O(n2)

This is because each cell of the matrix is processed at most 4 times. For Example, a particular cell can call a cell to its north, east, west or south.

Space Complexity:
O(n2)

Since a 2D array is used to store "visited" elements hence the space complexity is quadratic.

We also want you to go through the solution video to understand the dry run of this program.
 */

class CountIslands{
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[m][n];

      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }

      // write your code here
      boolean[][] vis = new boolean[m][n];
      int count = 0;
      
      for(int i=0;i<m;i++){
          for(int j=0;j<n;j++){
             if(arr[i][j] == 0 && vis[i][j] == false){
                 dfs(arr,i,j,vis);
                 count++;  //means every time a call is shot(after call)
             } 
          }
      } 
      
      System.out.print(count);
      
      
   }
   
   public static void dfs(int[][] ar, int i, int j, boolean[][] vis){
       
       if(i<0 || j<0 || i>= ar.length || j>= ar[0].length || ar[i][j] == 1 || vis[i][j] == true){
           return;
       }
       vis[i][j] = true;
       
       //calls
       dfs(ar,i-1,j,vis);
       dfs(ar,i,j+1,vis);
       dfs(ar,i+1,j,vis);
       dfs(ar,i,j-1,vis);
       
       return;
       
       
       
   }
}

/**
 * Sample Input
8
8
0 0 1 1 1 1 1 1
0 0 1 1 1 1 1 1
1 1 1 1 1 1 1 0
1 1 0 0 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 1 1 1 0
1 1 1 1 1 1 1 0
Sample Output
3
 */