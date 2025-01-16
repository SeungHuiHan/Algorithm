import java.util.*;

public class Main{
    private static ArrayList<int[]>[] adList;
    private static int[] costs;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int M=sc.nextInt();

        adList=new ArrayList[N+1];
        costs=new int[N+1];

        for(int i=1;i<=N;i++){
            adList[i]=new ArrayList<>();
        }

        Arrays.fill(costs,Integer.MAX_VALUE);

        for(int i=0;i<M;i++){
            int start=sc.nextInt();
            int end=sc.nextInt();
            int cost=sc.nextInt();

            adList[start].add(new int[]{end,cost});
        }

        int start=sc.nextInt();
        int arrival=sc.nextInt();

        daijkstra(start);

        System.out.println(costs[arrival]);
    }

    private static void daijkstra(int start){
        PriorityQueue<int []> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[1]));

        pq.add(new int[]{start,0});
        costs[start] = 0;

        while(!pq.isEmpty()){
            int[] current=pq.poll();
            int cNode=current[0];
            int cCost=current[1];

            if(cCost>costs[cNode]) continue; //이미 최소비용으로 계산되어있음

            for(int[] next:adList[cNode]){
                int nextNode=next[0];
                int cost=next[1];

                if(costs[cNode]+cost<costs[nextNode]){
                    costs[nextNode]=costs[cNode]+cost;
                    pq.add(new int[]{nextNode,costs[nextNode]});
                }
            }

        }

    }
}