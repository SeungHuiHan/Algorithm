import java.io.*;
import java.util.*;


public class Main {
    private static ArrayDeque<int[]> deque=new ArrayDeque<>();
    private static int[] dx={0,0,-1,1};
    private static int[] dy={-1,1,0,0};
    private static int[][] maps;
    private static int[][] dist;
    private static int N;

    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        int count=1;

        while((N=Integer.parseInt(bf.readLine()))!=0){
            maps=new int[N][N];
            dist=new int[N][N];

            for(int[] n:dist){
                Arrays.fill(n,Integer.MAX_VALUE);
            }

            for(int i=0;i<N;i++){
                st=new StringTokenizer(bf.readLine());
                for(int j=0;j<N;j++){
                    maps[i][j]=Integer.parseInt(st.nextToken());
                }
            }

            bfs(0,0);

            sb.append("Problem "+count+": "+dist[N-1][N-1]).append("\n");
            count++;

        }




        System.out.println(sb);

    }

    private static void bfs(int x,int y){
        deque.add(new int[]{x,y});
        dist[x][y]=maps[x][y];

        while(!deque.isEmpty()){
            int[] current=deque.poll();
            int cx=current[0];
            int cy=current[1];

            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=N ) continue;


                if(dist[nx][ny]>dist[cx][cy]+maps[nx][ny]){
                    dist[nx][ny]=dist[cx][cy]+maps[nx][ny];

                    if(maps[nx][ny]==0)
                        deque.addFirst(new int[]{nx,ny});
                    else
                        deque.add(new int[]{nx,ny});
                }


            }
        }
    }
}
