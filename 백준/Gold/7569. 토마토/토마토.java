import java.util.*;

public class Main{
    private static ArrayDeque<int []> queue;
    private static int M,N,H;
    private static int[][][] box;
    private static int maxCount=0;

    private static int[] dx={0,0,-1,1,0,0};
    private static int[] dy={0,0,0,0,-1,1};
    private static int[] dz={-1,1,0,0,0,0};


    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        M=sc.nextInt();
        N=sc.nextInt();
        H=sc.nextInt();

        box=new int[H][N][M];

        queue=new ArrayDeque<>();

        for(int h=0;h<H;h++){
            for(int n=0;n<N;n++){
                for(int m=0;m<M;m++){
                    box[h][n][m] = sc.nextInt();

                    if(box[h][n][m]==1){ //익은 토마토 큐에 추가
                        queue.add(new int[]{h,n,m});
                    }
                }
            }
        }


        bfs();

        for(int h=0;h<H;h++){
            for(int n=0;n<N;n++){
                for(int m=0;m<M;m++){
                    if(box[h][n][m]==0){
                        System.out.println(-1); //처음에 모든 토마토가 익지는 못한 상황
                        return;
                    }

                    maxCount=Math.max(maxCount,box[h][n][m]);
                }
            }
        }


        System.out.println(maxCount-1); // 처음에 모든 토마토가 다 익은 상황이면 maxCount=1이다.



    }

    private static void bfs(){
        while(!queue.isEmpty()){
            int[] current=queue.poll();
            int cz=current[0];
            int cy=current[1];
            int cx=current[2];

            for(int i=0;i<6;i++){
                int nz=cz+dz[i];
                int ny=cy+dy[i];
                int nx=cx+dx[i];


                if(nz>=0 && ny>=0 && nx>=0 && nz<H && ny<N && nx<M && box[nz][ny][nx]==0) {
                    box[nz][ny][nx]=box[cz][cy][cx]+1;
                    queue.add(new int[]{nz,ny,nx});
                }

            }

        }

    }
}