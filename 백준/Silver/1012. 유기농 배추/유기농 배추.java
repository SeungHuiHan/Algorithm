import java.util.*;

public class Main{
    private static int[] dx={0,0,-1,1};
    private static int[] dy={-1,1,0,0};
    private static int[][] maps;
    private static boolean[][] visited;
    private static ArrayDeque<int[]> dq=new ArrayDeque<>();
    private static int N,M;
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        StringBuilder sb=new StringBuilder();
        
        for(int l=0;l<T;l++){
            N=sc.nextInt();
            M=sc.nextInt();
            int K=sc.nextInt();

            maps=new int[N][M];
            visited=new boolean[N][M];
            for(int i=0;i<K;i++){
                int a=sc.nextInt();
                int b=sc.nextInt();
                maps[a][b]=1;
            }
            
            int count=0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(!visited[i][j] && maps[i][j]==1){
                        bfs(i,j);
                        count++;
                    }
                }
            }
            
            sb.append(count+"\n");
        }
        
        System.out.println(sb);
        
    }
    
    private static void bfs(int x,int y){
        dq.add(new int[]{x,y});
        visited[x][y]=true;
        
        while(!dq.isEmpty()){
            int[] current=dq.poll();
            int cx=current[0];
            int cy=current[1];
            
            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];
               
                if(nx<0 || ny<0|| nx>=N || ny>=M) continue;
                
                if(!visited[nx][ny]&& maps[nx][ny]==1){
                    visited[nx][ny]=true;
                    dq.add(new int[]{nx,ny});
                }
                
            }
        }
     
    }
}