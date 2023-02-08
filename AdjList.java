import java.util.LinkedList;

import java.util.*;
public class AdjList {
    private int v;
    private int e=0;
    private LinkedList<Integer> []list;

    public AdjList(int nodes){
        this.v=nodes;
        this.e=0;
        this.list=new LinkedList[nodes];
        for(int i=0;i<v;i++){
            list[i]=new LinkedList<>();
        }
    }

    public void addEdge(int u,int v){
        this.list[u].add(v);
        this.list[v].add(u);
        e++;
    }

    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(v+" Vertices "+e+" Edges\n");
        for(int i=0;i<v;i++){
            sb.append(i+":");
            for(int element:list[i]){
                sb.append(element+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        AdjList g=new AdjList(4);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(3, 2);
        System.out.println(g);
    }
}
