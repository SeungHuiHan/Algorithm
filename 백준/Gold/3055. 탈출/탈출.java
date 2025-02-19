import java.util.*;

public class Main{
    private static ArrayDeque<int[]> deque=new ArrayDeque<>();
    private static int[] dx={0,0,-1,1};
    private static int[] dy={-1,1,0,0};
    private static char[][] maps;
    private static boolean[][] visited;
    private static int[][] waterTime;
    private static int R,C;
    private static int[] Hedgehog=new int[2];

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        R=sc.nextInt();
        C=sc.nextInt();
        sc.nextLine();

        maps=new char[R][C];
        visited=new boolean[R][C];

        waterTime=new int[R][C];
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                waterTime[i][j]=Integer.MAX_VALUE;
            }
        }

        for(int i=0;i<R;i++){
            String s=sc.nextLine();
            for(int j=0;j<C;j++){
                if(s.charAt(j)=='S'){
                    Hedgehog[0]=i;
                    Hedgehog[1]=j;
                }else if(s.charAt(j)=='*'){
                    deque.add(new int[]{i,j,0});
                }
                maps[i][j]=s.charAt(j);
            }
        }

        water(); //홍수
        deque.clear();

        int answer=HedgehogLoad(Hedgehog[0],Hedgehog[1],0);
        System.out.println(answer==-1?"KAKTUS":answer);
    }

    private static void water(){
        while(!deque.isEmpty()){
            int[] current=deque.poll();
            int cx=current[0];
            int cy=current[1];
            int time=current[2];


            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];

                if(nx<0 ||ny<0 || nx>=R ||ny>=C) continue;

                if(maps[nx][ny]=='.' && waterTime[nx][ny]>time+1){
                    waterTime[nx][ny]=time+1; //홍수 시간
                    deque.add(new int[]{nx,ny,time+1});
                }

            }
        }
    }

    private static int HedgehogLoad(int x,int y,int t){
        deque.add(new int[]{x,y,t});
        visited[x][y]=true;

        while(!deque.isEmpty()){
            int[] current=deque.poll();
            int cx=current[0];
            int cy=current[1];
            int time=current[2];


            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];

                if(nx<0 ||ny<0 || nx>=R ||ny>=C) continue;

                if(maps[nx][ny]=='D'){
                    if(time<=waterTime[cx][cy]) return time+1;
                    else return -1;
                }
                if(maps[nx][ny]=='.'&& !visited[nx][ny] && waterTime[nx][ny]>time+1){
                    visited[nx][ny]=true;
                    deque.add(new int[]{nx,ny,time+1});
                }

            }
        }
        return -1;

    }
    
    
}