import java.util.*;

public class Main{
    private static int[] dx={0,0,-1,1};
    private static int[] dy={-1,1,0,0};
    private static char[][] maps;
    private static boolean[][] jvisited;
    private static int[][] fcount;
    private static ArrayDeque<int[]> jdq=new ArrayDeque<>();
    private static ArrayDeque<int[]> fdq=new ArrayDeque<>();
    private static int R,C;
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        R=sc.nextInt();
        C=sc.nextInt();
        sc.nextLine();
        
        jvisited=new boolean[R][C];
        fcount=new int[R][C];
        maps=new char[R][C];
        
        for(int i=0;i<R;i++){
            Arrays.fill(fcount[i],Integer.MAX_VALUE);
        }
        
        int jx=0;
        int jy=0;
        for(int i=0;i<R;i++){
            String s=sc.nextLine();
            for(int j=0;j<C;j++){
                maps[i][j]=s.charAt(j);
                
                if(maps[i][j]=='J'){ //지훈
                     jx=i;
                     jy=j;
                }
                if(maps[i][j]=='F'){//불
                     fdq.add(new int[]{i,j});
                     fcount[i][j]=0;
                }
            }
        }
        fbfs();
        int jcount=jbfs(jx,jy,0);
        
        if(jcount==-1) System.out.println("IMPOSSIBLE");
        else     System.out.println(jcount);
        
        
    }
    
    private static void fbfs(){
        while(!fdq.isEmpty()){
            int[] current=fdq.poll();
            int cx=current[0];
            int cy=current[1];
        
            
            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];
               
                if(nx<0 || ny<0|| nx>=R || ny>=C|| maps[nx][ny]=='#') continue;
                
                if(fcount[nx][ny]==Integer.MAX_VALUE){
                    fcount[nx][ny]=fcount[cx][cy]+1;
                    fdq.add(new int[]{nx,ny});
                }
                
            }
        }
    }
    
    private static int jbfs(int x,int y,int count){
        jdq.add(new int[]{x,y,count});
        jvisited[x][y]=true;
        
        while(!jdq.isEmpty()){
            int[] current=jdq.poll();
            int cx=current[0];
            int cy=current[1];
            int cc=current[2];
            
            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];
               
                
                if(nx<0 || ny<0|| nx>=R || ny>=C){
                    return cc+1;
                }
                if(maps[nx][ny]=='#') continue;
                
                if(!jvisited[nx][ny] && cc+1<fcount[nx][ny]){
                    jvisited[nx][ny]=true;
                    jdq.add(new int[]{nx,ny,cc+1});
                }
                
            }
        }
        
        return -1;
    }
}