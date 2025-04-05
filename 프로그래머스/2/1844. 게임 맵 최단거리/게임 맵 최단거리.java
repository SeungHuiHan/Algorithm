import java.util.*;

class Solution {
    private static int[] dx={0,0,-1,1};
    private static int[] dy={-1,1,0,0};
    private static ArrayDeque<int[]> deque=new ArrayDeque<>();

    private static int[][] maps1;
    private static boolean[][] visited;


    public int solution(int[][] maps) {
        int answer = 0;

        maps1=new int[maps.length][maps[0].length];
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length;j++){
                maps1[i][j]=maps[i][j];
            }
        }


        visited=new boolean[maps.length][maps[0].length];


        return bfs(0,0,1);
    }


    private static int bfs(int x,int y,int c){
        deque.add(new int[]{x,y,c});
        visited[x][y]=true;

        while(!deque.isEmpty()){
            int[] current=deque.poll();
            int cx=current[0];
            int cy=current[1];
            int count=current[2];

            if(cx==maps1.length-1 && cy==maps1[0].length-1 ) return count;
            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];


                if(nx<0 || ny<0 || nx>=maps1.length || ny>=maps1[0].length) continue;

                


                if(maps1[nx][ny]==1 && !visited[nx][ny]){
                    visited[nx][ny]=true;
                    deque.add(new int[]{nx,ny,count+1});
                }


            }

            
        }
        return -1;
    }
}