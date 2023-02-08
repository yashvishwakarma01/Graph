class Solution {
   
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
       boolean [] visited =new boolean [V];
       ArrayList<Integer> list=new ArrayList<>();
       Queue<Integer> q=new LinkedList<>();
       visited[0]=true;
       q.offer(0);
       while(!q.isEmpty()){
           int u=q.poll();
           list.add(u);
           for(int item:adj.get(u)){
               if(!visited[item]){
                   visited[item]=true;
                   q.offer(item);
               }
           }
           
       }
       return list;
    }
}
