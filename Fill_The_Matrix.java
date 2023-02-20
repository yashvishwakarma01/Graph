// Given a matrix with dimensions N x M, entirely filled with zeroes except for one position at co-ordinates X and Y containing '1'. Find the minimum number of 
//iterations in which the wholematrix can be filled with ones.Note: In one iteration, '1' can be filled in the 4
//neighbouring elements of a cell containing '1

class Solution
{
	 static  class Pair{
        int x;
        int y;
        int t;
        Pair(int x,int y,int t){
            this.x=x;
            this.y=y;
            this.t=t;
        }
    }
	public static int minIteration(int N, int M, int x, int y){
		
	
		int [][] arr=new int[N][M];
		arr[x-1][y-1]=1;
		Queue<Pair> q=new LinkedList<>();
		q.offer(new Pair(x-1,y-1,0));
	
		int k=0,max=0;
		while(!q.isEmpty()){
		    Pair p=q.poll();
		    int u=p.x;
		    int v=p.y;
		    int t=p.t;
		    if(t>max){
		        max=t;
		    }
		    for(int i=-1;i<2;i++){
		        for(int j=-1;j<2;j++){
		            if(u+i>=0 && u+i<arr.length && (i+j)!=0 && (i-j)!=0 && v+j>=0 && (v+j)<arr[0].length && arr[u+i][v+j]==0  ){
		                arr[u+i][v+j]=1;
		               
		                q.offer(new Pair(u+i,v+j,p.t+1));
		                
		            }
		        }
		    }
		   
		}
		return max;
	}
}
