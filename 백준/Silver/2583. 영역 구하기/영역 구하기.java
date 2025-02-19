import java.util.*;

public class Main{
    private static int[][] maps;
    private static boolean[][] visited;
    private static ArrayDeque<int[] > deque=new ArrayDeque<>();
    private static int[] dx={0,0,-1,1};
    private static int[] dy={-1,1,0,0};
    private static ArrayList<Integer> list=new ArrayList<>();
    private static int areaCount=0;
    private static int area=0;
    private static int M,N;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        M=sc.nextInt();
        N=sc.nextInt();
        int K=sc.nextInt();

        maps=new int[N][M];
        visited=new boolean[N][M];

        for(int i=0;i<K;i++){
            int x1=sc.nextInt();
            int y1=sc.nextInt();
            int x2=sc.nextInt();
            int y2=sc.nextInt();

            for(int j=y1;j<y2;j++){
                for(int k=x1;k<x2;k++){
                    maps[k][j]=1;
                }
            }

        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(maps[i][j]==0 && !visited[i][j]){
                    area=0;
                    bfs(i,j);
                    list.add(area);
                    areaCount++;
                }
            }
        }

        Collections.sort(list);
        System.out.println(areaCount);
        for(Integer ans:list)
            System.out.print(ans+" ");
    }


    private static void bfs(int x,int y){
        deque.add(new int[]{x,y});
        visited[x][y]=true;
        area++;

        while(!deque.isEmpty()){
            int[] current=deque.poll();
            int cx=current[0];
            int cy=current[1];

            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];

                if(nx<0 || ny<0 || nx>=N ||ny>=M) continue;

                if(!visited[nx][ny]&& maps[nx][ny]==0){
                    visited[nx][ny]=true;
                    area++;
                    deque.add(new int[]{nx,ny});
                }
            }
        }
    }
}