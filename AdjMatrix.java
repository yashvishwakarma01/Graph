class AdjMatrix{
    private int v;
    private int e;
    private int [][] matrix;
    public AdjMatrix(int nodes){
          this.v=nodes;
          this.e=0;
          this.matrix=new int[nodes][nodes];
    }
    public void addEdge(int u,int v){
          this.matrix[u][v]=1;
          this.matrix[v][u]=1;
          e++;
    }

    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(v+" Vertices "+e+" Edges\n");
     
        for(int i=0;i<this.v;i++){
              sb.append(i+":");
              for(int w:matrix[i]){
                sb.append(w+" ");
              } 
              sb.append("\n");
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        AdjMatrix g=new AdjMatrix(4);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(3, 2);
        System.out.println(g);
    }
}