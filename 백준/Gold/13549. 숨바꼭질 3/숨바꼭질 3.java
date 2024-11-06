import java.util.*;
public class Main{
    private static ArrayDeque<int []> queue;
    private static boolean[] visited=new boolean[100001];
    private static int N;
    private static int K;
    private static int minTime=0;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        K=sc.nextInt();
        queue=new ArrayDeque<>();
        bfs(N,0);
        System.out.println(minTime);
    }

    private static void bfs(int start,int startCount){
        queue.add(new int[]{start,startCount});
        visited[start]=true;

        while(!queue.isEmpty()){
            int[] current=queue.poll();
            int position=current[0];
            int time=current[1];

            if(position==K){
                minTime=time;
                return;
            }
            int[] nextPositions={position-1,position+1,2*position};

            for(int next:nextPositions){
                if(next>=0&& next<=100000 && !visited[next]){
                    visited[next]=true;
                    if(next==2*position){
                        queue.addFirst(new int[]{next,time});
                    }else{
                        queue.add(new int[]{next,time+1});
                    }
                }

            }

        }

    }
}