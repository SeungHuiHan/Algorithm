import java.util.*;

public class Main{
    private static ArrayDeque<int []> queue;
    private static int M,N;
    private static int[][] box;
    private static int maxCount=0;
    private static int[] dx={-1,1,0,0};
    private static int[] dy={0,0,-1,1};

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        M=sc.nextInt();
        N=sc.nextInt();
        
        box=new int[N][M];
        queue=new ArrayDeque<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                box[i][j]=sc.nextInt();
                if(box[i][j]==1){
                    queue.add(new int[]{i,j});
                }
            }
        }

        bfs();

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){

                if(box[i][j]==0){
                    System.out.println(-1); //처음에 모든 토마토가 익지는 못한 상황
                    return;
                }else{
                    maxCount=Math.max(maxCount,box[i][j]);
                }

            }
        }
        
        // 결과 출력 (최소 일수는 1부터 시작하므로 -1)
        System.out.println(maxCount-1);
    }

    private static void bfs(){
        while(!queue.isEmpty()){
            int[] current=queue.poll();
            int cx=current[0];
            int cy=current[1];

            for(int i=0;i<4;i++){
                int nx=cx+dx[i];
                int ny=cy+dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<M && box[nx][ny]==0 ){
                    box[nx][ny]=box[cx][cy]+1;
                    queue.add(new int[]{nx,ny});
                }
            }
        }
    }
}