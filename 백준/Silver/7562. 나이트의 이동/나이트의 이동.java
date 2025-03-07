import java.util.*;

public class Main{
    private static ArrayDeque<int[]> deque;
    private static int[][] maps;
    private static boolean[][] visited;
    private static int[] dx={2,2,-2,-2,1,1,-1,-1};
    private static int[] dy={1,-1,1,-1,2,-2,2,-2};
    private static int n;
    private static int targetX,targetY;
    private static int count;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int T=sc.nextInt();

        for(int i=0;i<T;i++){
            n=sc.nextInt();
            maps=new int[n][n];
            visited=new boolean[n][n];

            int cx=sc.nextInt();
            int cy=sc.nextInt();
            targetX=sc.nextInt();
            targetY=sc.nextInt();
            count=0;

            deque=new ArrayDeque<>();
            if(cx==targetX && cy==targetY) System.out.println(0);
            else System.out.println(bfs(cx,cy,0));

        }
    }

    private static int bfs(int x,int y,int c){
        deque.add(new int[]{x,y,c});
        visited[x][y]=true;

        while(!deque.isEmpty()){
            int[] current=deque.poll();
            int cx=current[0];
            int cy=current[1];
            int count=current[2];

            for(int i=0;i<8;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];

                if(nx<0 || ny<0 || nx>=n || ny>=n) continue;

                if(nx==targetX && ny== targetY){
                    return count+1;
                }

                if(!visited[nx][ny]){
                    visited[nx][ny]=true;
                    deque.add(new int[]{nx,ny,count+1});
                }
            }
        }

        return -1;
    }
}