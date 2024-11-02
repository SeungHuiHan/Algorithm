import java.util.*;
public class Main {
    private static ArrayDeque<int[]> queue;
    private static String[][] maps;
    private static boolean[][] visited;
    private static int N;
    private static int M;
    private static int maxtime;
    private static int time;
    private static int[] dx={-1,1,0,0};
    private static int[] dy={0,0,-1,1};




    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        M=sc.nextInt();
        sc.nextLine();
        maps=new String[N][M];
        visited=new boolean[N][M];


        for(int i=0;i<N;i++){
            String[] input=sc.nextLine().split("");
            for(int j=0;j<M;j++){
                maps[i][j]=input[j];
            }
        }


        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(maps[i][j].equals("L")){
                    for(int l=0;l<N;l++){
                        Arrays.fill(visited[l], false);
                    }
                    maxtime=Math.max(maxtime,bfs(i,j));
                }
            }
        }

        System.out.println(maxtime);
    }


    private static int bfs(int r,int c){
        queue=new ArrayDeque<>();
        queue.add(new int[]{r,c,0});
        visited[r][c]=true;

        int maxcount=0;

        while(!queue.isEmpty()){
            int[] current=queue.poll();
            int cx=current[0];
            int cy=current[1];
            int count=current[2];
            maxcount=Math.max(maxcount,count);

            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];

                if(nx<0 || ny<0 ||nx>=N || ny>=M) continue;

                if(!visited[nx][ny] &&maps[nx][ny].equals("L") ){
                    visited[nx][ny]=true;
                    queue.add(new int[]{nx,ny,count+1});
                }
            }
        }


        return maxcount;
    }
}