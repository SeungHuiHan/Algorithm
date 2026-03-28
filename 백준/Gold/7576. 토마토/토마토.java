import java.util.*;

public class Main{
    private static int[] dx={0,0,-1,1};
    private static int[] dy={-1,1,0,0};
    private static int[][] maps;
    private static ArrayDeque<int[]> dq=new ArrayDeque<>();
    private static int N,M;
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        M=sc.nextInt();
        N=sc.nextInt();
        sc.nextLine();
        
        maps=new int[N][M];
        for(int i=0;i<N;i++){
            String[] s=sc.nextLine().split(" ");
            for(int j=0;j<M;j++){
                maps[i][j]=Integer.parseInt(s[j]);
                
                if(maps[i][j]==1){
                     dq.add(new int[]{i,j});
                }
            }
        }
        bfs();
        
        int max=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(maps[i][j]==0){
                    System.out.println(-1);
                    return;
                }
                max=Math.max(max,maps[i][j]);
            }
        }
        System.out.println(max-1);
        
    }
    
    private static void bfs(){
        while(!dq.isEmpty()){
            int[] current=dq.poll();
            int cx=current[0];
            int cy=current[1];
        
            
            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];
               
                if(nx<0 || ny<0|| nx>=N || ny>=M || maps[nx][ny]==-1) continue;
                
                if(maps[nx][ny]==0){
                    maps[nx][ny]=maps[cx][cy]+1;
                    dq.add(new int[]{nx,ny});
                }
                
            }
        }
    }
}