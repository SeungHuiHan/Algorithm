import java.io.*;
import java.util.*;

public class Main {
    private static int[] dx={0,0,-1,1};
    private static int[] dy={-1,1,0,0};
    private static ArrayDeque<int[]> dq = new ArrayDeque<>();
    private static boolean[][] visited;
    private static int[][] maps;
    private static int[][] firstMaps;
    private static int count;
    private static int N,M,T;

    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        StringBuilder sb=new StringBuilder();

         N=Integer.parseInt(st.nextToken());
         M=Integer.parseInt(st.nextToken());


        maps=new int[N][M];
        firstMaps=new int[N][M*3];
        visited=new boolean[N][M];


        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<3*M;j++){
                firstMaps[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        T=Integer.parseInt(bf.readLine());

        for(int i=0;i<N;i++){

            for(int j=0;j<3*M;j+=3){
                int r=firstMaps[i][j];
                int g=firstMaps[i][j+1];
                int b=firstMaps[i][j+2];

                if((r+g+b)/3>=T) maps[i][j/3]=255;
                else maps[i][j/3]=0;
            }
        }

        for(int i=0;i<N;i++){

            for(int j=0;j<M;j++){
                if(!visited[i][j] && maps[i][j]==255){
                    bfs(i,j);
                    count++;
                }
            }
        }



        System.out.println(count);
    }

    private static void bfs(int x,int y){
       dq.add(new int[]{x,y});
       visited[x][y]=true;

        while (!dq.isEmpty()) {
            int[] current = dq.poll();
            int cx=current[0];
            int cy=current[1];

            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=M || maps[nx][ny]==0) continue;

                if(!visited[nx][ny] && maps[nx][ny]==255){
                    visited[nx][ny]=true;
                    dq.add(new int[]{nx,ny});
                }


            }
        }
    }
}
