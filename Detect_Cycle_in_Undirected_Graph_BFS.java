class Pair{
    int key;
    int value;
    Pair(int key,int value){
        this.key=key;
        this.value=value;
    }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
       boolean [] visited=new boolean[V];
       Queue<Pair> q=new LinkedList<>();
       boolean b =false;
       for(int i=0;i<V;i++){
           if(!visited[i]){
                b=bfs(adj,q,i,visited);
               if(b){
                   break;
                   
               }
           }
       }
       return b;
       
    }
         // hum apne parent node ko pair me le kr chalege agar element parent k barabar nhi hai and visited nhi hai to queue me add kr denge agar 
    //element parent k barabar nhi hai and visited hai iska mtlb cycle hai..
    public boolean bfs(ArrayList<ArrayList<Integer>> adj, Queue<Pair> q,int i,boolean []visited){
        boolean b =false;
        visited[i]=true;
        q.offer(new Pair(i,-1));
        while(!q.isEmpty()){
            Pair u=q.poll();
            for(int element:adj.get(u.key)){
                if(element!=u.value && !visited[element]){
                    q.offer(new Pair(element,u.key));
                    visited[element]=true;
                }
                else if(element!=u.value && visited[element]==true){
                    b=true;
                }
            }
            
            
            
        }
        return b;
    }
}
