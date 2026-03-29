import java.util.*;

public class Main{
    private static int N,M,answer;
    private static int[][] maps;
    private static int[][] copymaps;
    private static boolean[][] visited;
    private static int[] dx={0,0,-1,1};
    private static int[] dy={-1,1,0,0};
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        N=sc.nextInt();
        M=sc.nextInt();
        sc.nextLine();
        
        visited=new boolean[N][M];

        
        maps=new int[N][M];
        copymaps=new int[N][M];
        for(int i=0;i<N;i++){
            String[] s=sc.nextLine().split(" ");
            for(int j=0;j<M;j++){
                maps[i][j]=Integer.parseInt(s[j]); 
            }
        }

        dfs(0);
     
        System.out.println(answer);
        
    }
    
    private static void dfs(int depth){
        if( depth==3) {
            for(int i=0;i<N;i++){
                copymaps[i]=maps[i].clone();
            }
            bfs();
            int count=0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(copymaps[i][j]==0){
                        count++;
                    }
                }
            }
            answer=Math.max(answer,count);
            
            return;
        }
        
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(maps[i][j]==0){
                    maps[i][j]=1;
                    dfs(depth+1);
                    maps[i][j]=0;
                }
            }
        }
        
    }
    
    private static void bfs(){
         ArrayDeque<int[]> vdq; vdq=new ArrayDeque<>();
        for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(copymaps[i][j]==2){
                        vdq.add(new int[]{i,j});
                    
                   }
                }
        }
        
        while(!vdq.isEmpty()){
            int[] current=vdq.poll();
            int cx=current[0];
            int cy=current[1];
            
            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];
                
                if(nx<0||ny<0||nx>=N||ny>=M
                   || copymaps[nx][ny]==1) continue;
                
                if(copymaps[nx][ny]==0){
                    copymaps[nx][ny]=2;
                    vdq.add(new int[]{nx,ny});
                }
            }
        }
    }
}