import java.io.*;
import java.util.*;


public class Main {
    private static ArrayDeque<int[]> deque=new ArrayDeque<>();
    private static int[] dx={0,0,-1,1};
    private static int[] dy={-1,1,0,0};
    private static char[][] maps;
    private static boolean[][] visited;
    private static int N,M;
    private static int doX,doY;
    private static int answer;

    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        maps=new char[N][M];
        visited=new boolean[N][M];



        for(int i=0;i<N;i++){
            String s=bf.readLine();
            for(int j=0;j<M;j++){
                if(s.charAt(j)=='I'){
                    doX=i;
                    doY=j;
                }
                maps[i][j] = s.charAt(j);
            }
        }

        bfs(doX,doY);

        if(answer==0) System.out.println("TT");
        else System.out.println(answer);

    }

    private static void bfs(int x,int y){
        deque.add(new int[]{x,y});
        visited[x][y]=true;

        while(!deque.isEmpty()){
            int[] current=deque.poll();
            int cx=current[0];
            int cy=current[1];

            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=M || maps[nx][ny]=='X') continue;


                if(!visited[nx][ny]){
                    visited[nx][ny]=true;
                    if(maps[nx][ny]=='P') answer++;
                    deque.add(new int[]{nx,ny});
                }


            }
        }
    }
}
