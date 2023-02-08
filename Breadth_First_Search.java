import java.util.*;
public class Breadth_First_Search {
    private int v;
    private int e=0;
    private LinkedList<Integer>[]list;
    public Breadth_First_Search(int nodes){
              this.v=nodes;
              this.e=0;
              this.list=new LinkedList[v];
              for(int i=0;i<v;i++){
                this.list[i]=new LinkedList<>();
              }
    }

    public void addEdge(int u,int v){
        this.list[u].add(v);
        this.list[v].add(u);
        e++;
    }

    public String toString(){
         StringBuilder sb=new StringBuilder();
        sb.append(v+ " Vertices "+e +" Edges\n");
        for(int i=0;i<v;i++){
            sb.append(i+": ");
            for(int element:list[i]){
                sb.append(element+" -|->");
            }
            sb.append("null");
            sb.append("\n");
            sb.append("-------------------\n");
        }
        return sb.toString();
    }
    public void bfs(int node){
         boolean [] visited=new boolean[this.v];
         Queue<Integer> q=new LinkedList<>();
         q.offer(node);
         visited[node]=true;
         System.out.print("The breadth first traversal is:");
         while(!q.isEmpty()){
            int u=q.poll();
            System.out.print(u+"->");
            for(int element:list[u]){
                if(!visited[element]){
                    visited[element]=true;
                    q.offer(element);
                }
            }
         }

    }

    public void recursiveDfs(int node){
        boolean [] visited=new boolean[v];
        System.out.print("\nThe Depth First Traversal is:");
        dfs(node,visited);
    }
    public void dfs(int node,boolean [] visited){
        visited[node]=true;
        System.out.print(node+"->");
        for(int element:list[node]){
            if(!visited[element])
                  dfs(element, visited);
        }
        return;
    }
    public void iterativeDfs(int node){
        boolean []visited=new boolean[this.v];
        Stack<Integer>stack=new Stack<>();
        stack.push(node);
        visited[node]=true;
        System.out.print("\nThe iterative DFS is:");
        while(!stack.isEmpty()){
            int u=stack.pop();
           
            System.out.print(u+"->");
            for(int element:list[u]){
                if(!visited[element]){
                    stack.push(element);
                    visited[element]=true;
                }
            }
        }
    }
    public static void main(String[] args) {
        Breadth_First_Search g=new Breadth_First_Search(6);
        g.addEdge(0, 1);
        g.addEdge(1, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(2, 4);
        g.addEdge(4, 5);
        System.out.println(g);
        g.bfs(0);
        g.recursiveDfs(0);
        g.iterativeDfs(0);
    }
}
