class Solution {
    
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
       boolean [] visited=new boolean[V];
       ArrayList<Integer> list=new ArrayList<>();
       list=dfs(0,visited,list,adj);
       return list;
    }
    public ArrayList<Integer> dfs(int x,boolean [] visited,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> adj){
        visited[x]=true;
        list.add(x);
        for(int item:adj.get(x)){
            if(!visited[item]){
                visited[item]=true;
                dfs(item,visited,list,adj);
            
        }
      
    }
      return list;
}
}
