import java.util.*;
import java.io.*;

public class Main{
    private static ArrayDeque<int[]> queue;
    private static char[][] maps;
    private static boolean[][] visited;
    private static int[] dx={0,0,-1,1};
    private static int[] dy={-1,1,0,0};
    private static int N;
    private static int areaCount;

    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(bf.readLine());
        maps=new char[N][N];
        visited=new boolean[N][N];

        for(int i=0;i<N;i++){
            String input=bf.readLine();
            for(int j=0;j<N;j++){
                maps[i][j]=input.charAt(j);
            }
        }

        queue=new ArrayDeque<>();

        bfsMaking();
        int redCount=areaCount;


        areaCount=0;
        //방문기록 초기화
        for(int i=0;i<N;i++){
            Arrays.fill(visited[i],false);
        }

        //G구역을 R로 전환
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(maps[i][j]=='G'){
                    maps[i][j]='R';
                }
            }
        }

        bfsMaking();
        int redNotCount=areaCount;


        System.out.println(redCount+" "+redNotCount);
    }

    private static void bfsMaking(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    redGreenAreaCount(i,j,maps[i][j]);
                    areaCount++;

                }
            }
        }
    }

    private static void redGreenAreaCount(int x,int y, char cha){
        queue.add(new int[]{x,y});

        while(!queue.isEmpty()){
            int[] current=queue.poll();
            int cx=current[0];
            int cy=current[1];

            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];

                if(nx<0 || ny<0 || nx>=N ||ny>=N  ) continue;

                if(!visited[nx][ny] && maps[nx][ny]==cha){
                    visited[nx][ny]=true;
                    queue.add(new int[]{nx,ny});
                }

            }
        }



    }
}