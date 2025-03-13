import java.util.*;

public class Main{
    private static  int N,M;
    private static  int[][] maps;
    private static  boolean[][] visited;
    private static  int[][] dx={{0,-1,0},{0,-1,0},{0,1,0},{0,1,0}};
    private static  int[][] dy={{0,0,-1},{0,0,1},{0,0,1},{0,0,-1}};
    private static  int maxPower=Integer.MIN_VALUE;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        M=sc.nextInt();
        maps=new int[N][M];
        visited=new boolean[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                maps[i][j]=sc.nextInt();
            }
        }

        backtracking(0,0,0);
        System.out.println(maxPower==Integer.MIN_VALUE?0:maxPower);
    }

    private static void backtracking(int x,int y,int sum){
        if (x == N) { // 모든 칸을 탐색 완료
            maxPower = Math.max(maxPower, sum);
            return;
        }

        int nextX = x, nextY = y + 1;
        if (nextY == M) { // 다음 줄로 이동
            nextX++;
            nextY = 0;
        }


        for(int k=0;k<4;k++){
            int x1 = x + dx[k][1];
            int y1 = y + dy[k][1];
            int x2 = x + dx[k][2];
            int y2 = y + dy[k][2];

            if(check(x,y) && check(x1,y1) && check(x2,y2)){
                visited[x][y]=true;
                visited[x1][y1]=true;
                visited[x2][y2]=true;

                backtracking(nextX, nextY, sum + 2 * maps[x][y] + maps[x1][y1] + maps[x2][y2]);
                visited[x][y]=false;
                visited[x1][y1]=false;
                visited[x2][y2]=false;
            }
        }

        // 현재 위치를 부메랑으로 사용하지 않고 넘어가기
        backtracking(nextX, nextY, sum);

    }

    private static boolean check(int x,int y){
        if(x<0 || y<0 || x>=N || y>=M ) return false;
        if(visited[x][y]) return false;
        return true;
    }
}