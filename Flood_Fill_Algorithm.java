// Flood Fill Algorithm

class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {   
        boolean [][]visited=new boolean[image.length][image[0].length];
       
        int color=image[sr][sc];
         return dfs(image,color,newColor,sr,sc,visited);
    }
    
    public int [][] dfs(int [][] image,int color,int newColor,int sr,int sc,boolean [][] visited){
        
        visited[sr][sc]=true;
        image[sr][sc]=newColor;
        for(int i=-1;i<2;i++){
            for(int j=-1;j<2;j++){
                if(sr+i>=0 && sr+i<image.length && sc+j>=0 && sc+j<image[0].length && (i+j)!=0 && (i-j)!=0 && visited[sr+i][sc+j]==false && image[sr+i][sc+j]==color){
                    
                    dfs(image,color,newColor,sr+i,sc+j,visited);
                }
            }
        }
        
        
        return image;
        
        
    }
    
}
