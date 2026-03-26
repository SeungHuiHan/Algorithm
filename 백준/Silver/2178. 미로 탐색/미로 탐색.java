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
        N=sc.nextInt();
        M=sc.nextInt();
        sc.nextLine();
        
        maps=new int[N+1][M+1];
        visited=new boolean[N+1][M+1];
        for(int i=1;i<=N;i++){
            String s=sc.nextLine();
            for(int j=1;j<=M;j++){
                maps[i][j]=s.charAt(j-1)-'0';
            }
        }
        
        System.out.println(bfs(1,1,1)); 
    }
    
    private static int bfs(int x,int y,int count){
        dq.add(new int[]{x,y,count});
        visited[x][y]=true;
        
        while(!dq.isEmpty()){
            int[] current=dq.poll();
            int cx=current[0];
            int cy=current[1];
            int cc=current[2];
            
            if(cx==N && cy==M){
                    return cc;
                }
            
            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];
               
                if(nx<1 || ny<1|| nx>N || ny>M) continue;
                
                if(!visited[nx][ny]&& maps[nx][ny]==1){
                    visited[nx][ny]=true;
                    dq.add(new int[]{nx,ny,cc+1});
                }
                
            }
        }
        return 0;
    }
}