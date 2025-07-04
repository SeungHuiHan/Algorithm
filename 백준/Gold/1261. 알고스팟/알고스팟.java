import java.io.*;
import java.util.*;


public class Main {
    private static ArrayDeque<int[]> deque=new ArrayDeque<>();
    private static int[] dx={0,0,-1,1};
    private static int[] dy={-1,1,0,0};
    private static int[][] maps;
    private static int[][] dist;
    private static int N,M;

    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        maps=new int[N][M];
        dist=new int[N][M];

        for(int[] m:dist){
            Arrays.fill(m,Integer.MAX_VALUE);
        }

        for(int i=0;i<N;i++){
            String s=bf.readLine();
            for(int j=0;j<M;j++){
                maps[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0,0);

        System.out.println(dist[N-1][M-1]);

    }

    private static void bfs(int x,int y){
        deque.add(new int[]{x,y});
        dist[x][y]=0;

        while(!deque.isEmpty()){
            int[] current=deque.poll();
            int cx=current[0];
            int cy=current[1];

            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=M ) continue;


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
