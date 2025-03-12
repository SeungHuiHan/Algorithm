import java.util.*;

public class Main{
    private static int[][] maps;
    private static boolean[]visited;
    private static int N,K;
    private static int minDistance=Integer.MAX_VALUE;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        K=sc.nextInt();
        maps=new int[N][N];
        visited=new boolean[N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                maps[i][j]=sc.nextInt();
            }
        }

        for(int k=0;k<N;k++){ //경유지
            for(int i=0;i<N;i++){ //출발지
                for(int j=0;j<N;j++){ //도착지
                    maps[i][j]=Math.min(maps[i][k]+maps[k][j],maps[i][j]);
                }
            }
        }

        visited[K]=true;

        backtracking(K,0,1); //이미 K행성은 방문함
        System.out.println(minDistance);
    }

    private static void backtracking(int start,int distance,int count){
        if(count==N){
            minDistance=Math.min(minDistance,distance);
            return;
        }

        for(int i=0;i<N;i++){
            if(start != i && !visited[i]){
                visited[i]=true;
                backtracking(i,distance+maps[start][i],count+1);
                visited[i]=false;
            }

        }
    }
}