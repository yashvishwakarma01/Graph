class Pair{
    int row;
    int col;
    int time;
    Pair(int row,int col,int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}

class Solution
{
    //Function to find minimum time required to rot all oranges. 
  public int orangesRotting(int[][] grid)
    { boolean [][]visited=new boolean[grid.length][grid[0].length];
       Queue<Pair>q=new LinkedList<>();
        
       for(int i=0;i<grid.length;i++){
          for(int j=0;j<grid[0].length;j++){
              if(grid[i][j]==2){
                  q.offer(new Pair(i,j,0));
                  visited[i][j]=true;
               }
           }
     }
        
      int max=0;
      while(!q.isEmpty()){
          Pair p=q.poll();
          if(p.time>max){
              max=p.time;
         }
      for(int i=-1;i<2;i++){
         for(int j=-1;j<2;j++){
            if(p.row+i>=0 && p.row+i<grid.length && p.col+j>=0 && p.col+j<grid[0].length && (i+j)!=0 && (i-j)!=0 &&!visited[p.row+i][p.col+j] && grid[p.row+i][p.col+j]==1){
                     visited[p.row+i][p.col+j]=true;
                      q.offer(new Pair(p.row+i,p.col+j,(p.time)+1));
                      grid[p.row+i][p.col+j]=2;
                    }
                }
            }
        }
        // Check all oranges are rotten or not,if not return -1 else return max time
        for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j]==1){
                        max=-1;
                        break;
                    }
            }
        }
        return max;
    }
}    
