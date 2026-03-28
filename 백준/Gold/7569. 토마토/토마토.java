import java.util.*;

public class Main{
    private static int[] dx={0,0,0,0,-1,1};
    private static int[] dy={0,0,-1,1,0,0};
    private static int[] dz={-1,1,0,0,0,0};
    private static int[][][] maps;
    private static ArrayDeque<int[]> dq=new ArrayDeque<>();
    private static int N,M,H;
    private static boolean cooked;
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        M=sc.nextInt();
        N=sc.nextInt();
        H=sc.nextInt();
        sc.nextLine();
        
        maps=new int[H][N][M];
        
        for(int h=0;h<H;h++){
            
            for(int i=0;i<N;i++){
                String[] s=sc.nextLine().split(" ");
                for(int j=0;j<M;j++){
                    
                    maps[h][i][j]=Integer.parseInt(s[j]);
                
                    if(maps[h][i][j]==1){
                         dq.add(new int[]{h,i,j});
                    }
                }
                
            }
        }
        bfs();
        
        int max=0;
        for(int h=0;h<H;h++){
             for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
               
                    if(maps[h][i][j]==0){
                        System.out.println(-1);
                        return;
                    }
                    
                    max=Math.max(max,maps[h][i][j]);
                }
               
                
            }
        }
        
        if(!cooked) System.out.println(0);
        else System.out.println(max-1);
        
    }
    
    private static void bfs(){
        while(!dq.isEmpty()){
            int[] current=dq.poll();
            int cz=current[0];
            int cx=current[1];
            int cy=current[2];
            
            
            for(int i=0;i<6;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];
                int nz=cz+dz[i];
               
                if(nx<0 || ny<0|| nz<0 ||
                   nx>=N || ny>=M || nz>=H|| 
                   maps[nz][nx][ny]==-1) continue;
                
                if(maps[nz][nx][ny]==0){
                    cooked=true;
                    maps[nz][nx][ny]=maps[cz][cx][cy]+1;
                    dq.add(new int[]{nz,nx,ny});
                }
                
            }
        }
    }
}