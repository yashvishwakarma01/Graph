class Solution {
    
    public int numIslands(char[][] grid) {
        int z=0;
        int x=grid.length;
        int y=grid[0].length;
        boolean [][] visited=new boolean[x][y];
      for(int i=0;i<x;i++){
          for(int j=0;j<y;j++){
              if(grid[i][j]=='1' && !visited[i][j]){
                  dfs(visited,i,j,grid);
                  z++;
              }
          }
        
      }
        return z;
    }
    
    public void dfs(boolean [][] visited,int i ,int j,char[][] grid){
        visited[i][j]=true;
        for(int l=-1;l<2;l++){
            for(int k=-1;k<2;k++){
                if( i+l>=0 && i+l<grid.length && j+k>=0 && j+k<grid[0].length && !visited[i+l][j+k] && grid[i+l][j+k]=='1'){
                    dfs(visited,i+l,j+k,grid);
                }
            }
        }
        return;
    }
}
