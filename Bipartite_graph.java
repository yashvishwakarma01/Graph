//Given an adjacency list of a graph adj  of V no. of vertices having 0 based index. Check whether the graph is bipartite or not

class Pair{
    int child;
    int parent;
    Pair(int child,int parent){
        this.parent=parent;
        this.child=child;
    }
}
class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {  Queue<Pair> q=new LinkedList<>();
    boolean b=false;
       int [] color=new int[V];
       int [] visited=new int[V];
        for(int i=0;i<V;i++){
            color[i]=-1;
        }  
        for(int i=0;i<V;i++){    // Calling for each vertices and checking it is visited or not because can be connected and disconnnected
            if(visited[i]==0){
                b=bfs(color,adj,visited,q,i);
                if(b==false)
                    break;
            }
        }
       return b ;     
    }
    public boolean bfs(int [] color,ArrayList<ArrayList<Integer>>adj,int [] visited,Queue<Pair> q,int z){
          if(color.length==1)
                  return true;
        color[z]=0;
        visited[z]=1;
        q.offer(new Pair(z,-1));
        boolean b=true;
        while(!q.isEmpty()){
           Pair u=q.poll();
           for(int element:adj.get(u.child)){
               if(visited[element]==0){
                   q.offer(new Pair(element,u.child));
                   visited[element]=1;
                   if(color[u.child]==1){
                       color[element]=0;
                   }else if(color[u.child]==0){
                       color[element]=1;
                   }
               }else if(visited[element]==1 && element!=u.parent && color[u.child]==color[element]){
                   b=false;
                   break;
               }
           }         
        }       
  return b; 
  }            
}
