import java.util.*;

public class Main {
    private static int count=0;
    private static int minsecond=Integer.MAX_VALUE;
    private static ArrayDeque<int []> queue;
    private static int[] visited;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int K=sc.nextInt();
        visited=new int[100001];

        queue=new ArrayDeque<>();
        bfs(N,K);

        System.out.println(minsecond);
        System.out.println(count);
    }

    private static void bfs(int start,int end){
        queue.add(new int[]{start,0});

        while(!queue.isEmpty()){
            int[] current=queue.poll();
            int position=current[0];
            int time=current[1];

            if(position==end){
                if(minsecond==time)
                    count++;
                else if(minsecond>time){
                    minsecond=time;
                    count=1;
                }else continue;
            }


            int[] nextPositions={position+1,position-1,position*2};
            for(int next:nextPositions){
                if(next>=0 && next<=100000){
                    if(visited[next]==0 || visited[next]==time+1){ //처음 가는 경로 or 같은 시간에 같은 경로 도달
                        visited[next]=time+1;
                        queue.add(new int[]{next,time+1});
                    }
                }
            }
        }


    }
}
