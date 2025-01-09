import java.util.*;
import java.io.*;

public class Main{
    private static ArrayDeque<int []> queue;
    private static int[] dx={0,0,-1,1};
    private static int[] dy={-1,1,0,0};
    private static int[][] maps;
    private static int[][] mapsCopy;
    private static boolean[][] visited;
    private static int maxSafeArea=0;
    private static int totalCells=0;
    private static int N,M;

    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        maps=new int[N][M];


        totalCells=N*M;

        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++){
                maps[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<totalCells;i++){
            for(int j=i+1;j<totalCells;j++){
                for(int k=j+1;k<totalCells;k++){

                    mapsCopy=new int[N][M];
                    for(int l=0;l<N;l++){
                        mapsCopy[l]= Arrays.copyOf(maps[l],maps[l].length); //복사
                    }

                    if(mapsCopy[i/M][i%M]==0 && mapsCopy[j/M][j%M]==0 && mapsCopy[k/M][k%M]==0){
                        mapsCopy[i/M][i%M]=1;
                        mapsCopy[j/M][j%M]=1;
                        mapsCopy[k/M][k%M]=1;

                        queue=new ArrayDeque<>();
                        visited=new boolean[N][M];
                        for(int q=0;q<N;q++){
                            for(int w=0;w<M;w++){
                                if(maps[q][w]==2 && !visited[q][w]){
                                    virusSpread(q,w);

                                }
                            }
                        }
                        safeAreaCount();

                    }

                }
            }
        }
        System.out.println(maxSafeArea);
    }

    //bfs
    private static void virusSpread(int x,int y){
        queue.add(new int[]{x,y});
        visited[x][y]=true;

        while(!queue.isEmpty()){
            int[] current=queue.poll();
            int cx=current[0];
            int cy=current[1];

            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=M || mapsCopy[nx][ny]==1) continue;

                if(!visited[nx][ny] && mapsCopy[nx][ny]==0){
                    mapsCopy[nx][ny]=2;
                    visited[nx][ny]=true;
                    queue.add(new int[]{nx,ny});
                }
            }
        }

    }

    //안전영역 카운트
    private static void safeAreaCount(){
        int count=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(mapsCopy[i][j]==0)
                    count++;
            }
        }

        maxSafeArea=Math.max(maxSafeArea,count);
    }
}