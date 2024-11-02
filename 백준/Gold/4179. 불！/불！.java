
import java.util.*;
public class Main {
    private static ArrayDeque<int []>queue;
    private static String[][] maps;
    private static boolean[][] visited;
    private static int[][] fireTime;
    private static int N;
    private static int M;
    private static int[] dx={-1,1,0,0};
    private static int[] dy={0,0,-1,1};


    public static void main(String[] agrs){
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        M=sc.nextInt();
        sc.nextLine();

        maps=new String[N][M];
        visited=new boolean[N][M];
        int[] jihun=new int[2]; //지훈 초기 위치 배열
        int[] fire=new int[2]; //불 초기 위치 배열
        fireTime=new int[N][M];

        queue=new ArrayDeque<>();
        for(int i=0;i<N;i++){
            String[] input=sc.nextLine().split("");
            for(int j=0;j<M;j++){
                maps[i][j]=input[j];
                if(input[j].equals("J")){//지훈 초기 위치
                    jihun[0]=i;
                    jihun[1]=j;

                }else if(input[j].equals("F")){//불 초기 위치
                    queue.add(new int[]{i,j,0});
                    fireTime[i][j]=0;
                }else
                    fireTime[i][j]=Integer.MAX_VALUE;

            }
        }


        fireBfs(); //불번짐

        queue.clear(); //큐 초기화
        int escapeTime=jihunBfs(jihun[0],jihun[1]); //지훈이 탈출

        System.out.println(escapeTime==-1?"IMPOSSIBLE":escapeTime);

    }

    //불번짐 시간 
    private static void fireBfs(){
        while(!queue.isEmpty()){
            int[] current=queue.poll();
            int cx=current[0];
            int cy=current[1];
            int time=current[2];


            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];

                if(nx<0 || ny<0 || nx>=N||ny>=M) continue;


                if(maps[nx][ny].equals(".") && fireTime[nx][ny]>time+1){
                    fireTime[nx][ny]=time+1; //최소 불 번짐 시간 갱신
                    queue.add(new int[]{nx,ny,time+1});
                }

            }

        }

    }

    //탈출
    private static int jihunBfs(int r,int c){
        queue.add(new int[]{r,c,0});
        visited[r][c]=true;

        while(!queue.isEmpty()){
            int[] current=queue.poll();
            int cx=current[0];
            int cy=current[1];
            int time=current[2];

            if(cx==0 || cy==0 || cx==(N-1)||cy==(M-1)) return time+1; //가장자리


            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];


                if(nx<0 || ny<0 || nx>=N||ny>=M) continue;

                //아직 지훈이가 방문하지않고, 불보다 먼저 도착할때
                if(!visited[nx][ny] && maps[nx][ny].equals(".")&&fireTime[nx][ny]>time+1){
                    visited[nx][ny]=true;
                    queue.add(new int[]{nx,ny,time+1});
                }

            }
        }
        return -1;
    }
}
