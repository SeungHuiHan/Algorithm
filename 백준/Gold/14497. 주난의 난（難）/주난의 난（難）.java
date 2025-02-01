import java.util.*;

public class Main{
    private static ArrayDeque<int[]> deque;
    private static int[] dx={-1,1,0,0};
    private static int[] dy={0,0,-1,1};
    private static int[][] maps;
    private static boolean[][] visited;
    private static int N,M;
    private static int[] bumin=new int[2];
    private static int[] zunan=new int[2];
    private static int count;
    private static boolean finish;

    public static void main(String[] Args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        maps=new int[N][M];
        visited=new boolean[N][M];

        zunan[0]=sc.nextInt()-1;
        zunan[1]=sc.nextInt()-1;
        bumin[0]=sc.nextInt()-1;
        bumin[1]=sc.nextInt()-1;
        sc.nextLine();

        for(int i=0;i<N;i++){
            String[] s=sc.nextLine().split("");

            for(int j=0;j<M;j++){
                char c=s[j].charAt(0);

                if(c=='*') maps[i][j]=3;
                if(c=='#') maps[i][j]=4;
                else maps[i][j]=c-'0';

            }
        }

        deque=new ArrayDeque<>();
        while(!finish){

            for(int i=0;i<N;i++){
                Arrays.fill(visited[i],false);
            }
            dfs(zunan[0],zunan[1]);
            count++;
        }


        System.out.println(count);
    }

    private static void dfs(int x,int y){
        deque.add(new int[]{x,y});
        visited[x][y]=true;

        while(!deque.isEmpty()){
            int[] current=deque.poll();
            int cx=current[0];
            int cy=current[1];

            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];
                if(nx<0 || ny<0 || nx>=N|| ny>=M || visited[nx][ny]) continue;
                if(maps[nx][ny]==4){
                    finish=true;
                    return;
                }

                if(maps[nx][ny]==1){
                    maps[nx][ny]=0;
                    visited[nx][ny]=true;
                }else if(maps[nx][ny]==0){
                    visited[nx][ny]=true;
                    deque.add(new int[]{nx,ny});
                }

            }
        }
    }
}