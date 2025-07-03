import java.util.*;
import java.io.*;

public class Main{
    private static ArrayDeque<int[]> deque=new ArrayDeque<>();
    private static int[] dx={0,0,-1,1};
    private static int[] dy={-1,1,0,0};
    private static int[][] maps;
    private static int[][] answers;
    private static boolean[][] visited;
    private static int startX,startY;
    private static int N,M;

    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        maps=new int[N][M];
        answers=new int[N][M];
        visited=new boolean[N][M];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++){
                int m=Integer.parseInt(st.nextToken());
                if(m==2){
                    startX=i;
                    startY=j;
                }
                maps[i][j]=m;
            }
        }

        bfs(startX,startY);

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(maps[i][j]==1 && answers[i][j]==0)
                    sb.append(-1+" ");
                else
                    sb.append(answers[i][j]+" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

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

                if(nx<0 || ny<0 || nx>=N || ny>=M ||maps[nx][ny]==0) continue;

                if(!visited[nx][ny]){
                    visited[nx][ny]=true;
                    answers[nx][ny]=answers[cx][cy]+1;
                    deque.add(new int[]{nx,ny});
                }
            }
        }
    }
}