import java.io.*;
import java.util.*;

public class Main{
    private static ArrayDeque<int[]> deque=new ArrayDeque<>();
    private static int[] dx={0,0,-1,1};
    private static int[] dy={-1,1,0,0};
    private static int[][] maps;
    private static boolean[][] visited;
    private static int N,M,K;
    private static int count;

    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        maps=new int[N][M];
        visited=new boolean[N][M];

        for(int i=0;i<K;i++){
            st=new StringTokenizer(bf.readLine());
            int r=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            maps[r-1][c-1] = 1;

        }

        int maxCount=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if (!visited[i][j] && maps[i][j] == 1) { 
                    count = 1;
                    bfs(i, j);
                    maxCount = Math.max(maxCount, count);
                }
            }

        }

        System.out.println(maxCount);

    }

    private static void bfs(int x,int y){
        deque.add(new int[]{x,y});
        visited[x][y]=true;

        while(!deque.isEmpty()){
            int[] current=deque.poll();
            int cx=current[0];
            int cy=current[1];

            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=M || maps[nx][ny]==0) continue;


                if(!visited[nx][ny]){
                    visited[nx][ny]=true;
                    if(maps[nx][ny]==1) count++;
                    deque.add(new int[]{nx,ny});
                }


            }
        }
    }
}
