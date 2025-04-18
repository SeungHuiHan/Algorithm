import java.util.*;
import java.io.*;

public class Main{
    private static int[] dx={0,0,-1,1};
    private static int[] dy={-1,1,0,0};
    private static int n,m;
    private static int[][] maps;

    private static boolean[][] visited;
    private static ArrayDeque<int[]> deque=new ArrayDeque<>();

    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(bf.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        maps=new int[n][m];
        visited=new boolean[n][m];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<m;j++){
                maps[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int countPicture=0;
        int maxArea=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && maps[i][j]==1){
                    int area=bfs(i,j);
                    countPicture++;
                    maxArea=Math.max(maxArea,area);
                }
            }
        }


        System.out.println(countPicture);
        System.out.println(maxArea);

    }

    private static int bfs(int x,int y){
        int area = 0;
        deque.add(new int[]{x,y});
        visited[x][y]=true;


        while(!deque.isEmpty()){
            int[] current=deque.poll();
            int cx=current[0];
            int cy=current[1];

            area++;

            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];

                if(nx<0 || ny<0 || nx>=n ||ny>=m) continue;

                if(!visited[nx][ny] && maps[nx][ny]==1){
                    visited[nx][ny]=true;
                    deque.add(new int[]{nx,ny});

                }
            }
        }

        return area;
    }
}