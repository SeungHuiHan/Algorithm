import java.util.*;

public class Main{
    private static int[] dx={0,0,-1,1};
    private static int[] dy={-1,1,0,0};
    private static boolean[][] visited;
    private static ArrayDeque<int[]> dq=new ArrayDeque<>();
    private static int[][] map;
    
    private static int N;
    private static int count=0;
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> answer=new ArrayList<>();
        N=sc.nextInt();
        sc.nextLine();
            
        visited=new boolean[N][N];
        map=new int[N][N];
        for(int i=0;i<N;i++){
            String[] s=sc.nextLine().split("");
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(s[j]);
            }
        }
        
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==1 && !visited[i][j]){
                    count=0;
                    bfs(i,j);
                    answer.add(count);
                }
            }
        }
        Collections.sort(answer);
        
        StringBuilder sb=new StringBuilder();
        sb.append(answer.size()+"\n");
        for(int i=0;i<answer.size();i++){
            sb.append(answer.get(i)+"\n");
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
            count++;
            
            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];
                
                if(nx<0 || ny <0 || nx>=N || ny >=N) continue;
                if(map[nx][ny]==1 && !visited[nx][ny]){
                    visited[nx][ny]=true;
                    dq.add(new int[]{nx,ny});
                }
                
            }
        }
    }
}