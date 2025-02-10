import java.util.*;

public class Main{
    private static int[][] maps;
    private static boolean[][] visited;
    private static int[] dx={0,0,-1,1,-1,1,-1,1}; //대각선도 ok
    private static int[] dy={-1,1,0,0,-1,1,1,-1};
    private static ArrayDeque<int[]> queue;
    private static int w,h;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        while(true){
            w=sc.nextInt();
            h=sc.nextInt();

            if(w==0 && h==0) break; //종료

            // 배열 크기 변경 (h: 행, w: 열)
            maps=new int[h][w];
            visited=new boolean[h][w];

            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    maps[i][j]=sc.nextInt();
                }
            }

            queue=new ArrayDeque<>();

            int count=0;
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(!visited[i][j] && maps[i][j]==1){
                        bfs(i,j);
                        count++;
                    }
                }
            }

            System.out.println(count);

        }
    }

    private static void bfs(int x,int y){
        queue.add(new int[]{x,y});
        visited[x][y]=true;

        while(!queue.isEmpty()){
            int[] current=queue.poll();
            int cx=current[0];
            int cy=current[1];

            for(int i=0;i<8;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];

                if(nx<0 || ny<0 || nx>=h || ny >=w) continue;

                if(!visited[nx][ny] && maps[nx][ny]==1){
                    visited[nx][ny]=true;
                    queue.add(new int[]{nx,ny});
                }
            }
        }
    }
}