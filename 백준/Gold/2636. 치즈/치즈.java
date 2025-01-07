import java.util.*;

public class Main{
    private static int[] dx={0,0,-1,1};
    private static int[] dy={-1,1,0,0};
    private static ArrayDeque<int[]> queue;
    private static int[][] maps;
    private static boolean[][] visited;
    private static int cheeseTime=0;
    private static int cheeseCount=0;
    private static int N,M;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        M=sc.nextInt();
        maps=new int[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                maps[i][j]=sc.nextInt();
            }
        }

        queue=new ArrayDeque<>();

        while(true){
            int currentCheeseCount=cheeseCount(); //현재 치즈 개수

            if(currentCheeseCount==0) break;
            cheeseCount=currentCheeseCount;
            meltCheese(); //bfs
            cheeseTime++;
        }

        System.out.println(cheeseTime);
        System.out.println(cheeseCount);
    }

    private static int cheeseCount(){
        int count=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(maps[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }

    private static void meltCheese(){
        queue.add(new int[]{0,0});
        visited=new boolean[N][M];
        visited[0][0]=true;

        while(!queue.isEmpty()){
            int[] current=queue.poll();
            int cx=current[0];
            int cy=current[1];

            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];

                if(nx<0 || ny<0 || nx>=N || ny >=M || visited[nx][ny]) continue;
                visited[nx][ny]=true;

                if(maps[nx][ny]==1){
                    maps[nx][ny]=0;
                    
                }else{
                    queue.add(new int[]{nx,ny});
                }


            }
        }
    }
}