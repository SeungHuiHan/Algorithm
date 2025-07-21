import java.io.*;
import java.util.*;

public class Main {
    private static int[] dx={0,1};
    private static int[] dy={1,0};
    private static ArrayDeque<int[]> dq = new ArrayDeque<>();
    private static boolean[][] visited;
    private static int[][] maps;
    private static int N;

    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        N=Integer.parseInt(st.nextToken());

        maps=new int[N][N];
        visited=new boolean[N][N];


        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++){
                maps[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(0,0)?"HaruHaru":"Hing");
    }

    private static boolean bfs(int x,int y){
        dq.add(new int[]{x,y});
        visited[x][y]=true;


        while (!dq.isEmpty()) {
            int[] current = dq.poll();
            int cx=current[0];
            int cy=current[1];

            if (cx == N - 1 && cy == N - 1) return true;
            int jump=maps[cx][cy];
            for(int i=0;i<2;i++){
                int nx=cx+jump*dx[i];
                int ny=cy+jump*dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=N ) continue;


                if(!visited[nx][ny]){
                    visited[nx][ny]=true;
                    dq.add(new int[]{nx,ny});
                }

            }
        }

        return false;
    }
}
