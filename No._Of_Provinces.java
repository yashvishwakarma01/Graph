class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean [] visited=new boolean[V];
      
     // Creating new arrayList because adjacency matrix is given,we will work with adjacency list 
    ArrayList<ArrayList<Integer>> list=new ArrayList<>(V);
    for(int i=0;i<V;i++){
        list.add(new ArrayList<>());
    }
    
      // Copying the value of adjacency matrix into adjacency list
    for(int i=0;i<V;i++){
        for(int j=0;j<V;j++){
            if(adj.get(i).get(j)==1 && i!=j){
                list.get(i).add(j);
            }
        }
    }
        int count=0;
       for(int i=0;i<V;i++){
           if(!visited[i]){
               dfs(list,visited,i);
               count++;
           }
       }
       return count;
    }
    
    public static void dfs(ArrayList<ArrayList<Integer>> list,boolean [] visited,int i){
        visited[i]=true;
        for(int element:list.get(i)){
            if(!visited[element]){
                 dfs(list,visited,element);
            }
        }
        
        
    }
   
}
