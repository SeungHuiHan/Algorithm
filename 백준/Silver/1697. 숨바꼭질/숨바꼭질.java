import java.util.*;

public class Main{
   private static ArrayDeque<int []> queue;
    private static boolean[] visited=new boolean[100001];
    private static int N;
    private static int K;
    private static int minCount=Integer.MAX_VALUE;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        K=sc.nextInt();
        queue=new ArrayDeque<>();
        bfs(N,0);
        System.out.println(minCount);
    }

    private static void bfs(int start,int startCount){
        queue.add(new int[]{start,startCount});
        visited[start]=true;

        while(!queue.isEmpty()){
            int[] current=queue.poll();
            int position=current[0];
            int count=current[1];

            //System.out.println("count: "+count);

            if(position==K){
                minCount=Math.min(minCount,count);
                return;
            }
            
           // if(position<=0) continue;

            int[] nextPositions={position-1,position+1,2*position};

            for(int next:nextPositions){
                if(next>=0&& next<=100000){
                    if(!visited[next]){
                        visited[next]=true;
                        queue.add(new int[]{next,count+1});
                    }
                }

            }

        }

    }
}