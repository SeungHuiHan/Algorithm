import java.util.*;

public class Main{
    private static ArrayList<int[]>[] adList;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int M=sc.nextInt();
        int X=sc.nextInt();

        adList=new ArrayList[N+1];


        for(int i=0;i<=N;i++)
            adList[i]=new ArrayList<>();

        for(int i=0;i<M;i++){
            int start=sc.nextInt();
            int end=sc.nextInt();
            int distance=sc.nextInt();

            adList[start].add(new int[]{end,distance});
        }

        int[] toX=daijkstra(X,N); // X에서 모든 마을가는 최단 거리

        int maxTime=0;
        for(int i=1;i<=N;i++){
            if(i!=X){
                int[] fromX=daijkstra(i,N); //모든 마을에서 X로 가는 최단 거리
                if(toX[i]!=Integer.MAX_VALUE && fromX[i]!=Integer.MAX_VALUE){
                    maxTime=Math.max(maxTime,toX[i]+fromX[X]); //왕복 거리
                }
            }

        }

        System.out.println(maxTime);
    }

    private static int[] daijkstra(int start,int N){
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        pq.add(new int[]{start,0});

        int[] distances=new int[N+1];
        Arrays.fill(distances,Integer.MAX_VALUE);
        distances[start]=0;

        while(!pq.isEmpty()){
            int[] current=pq.poll();
            int cNode=current[0];
            int cDistane=current[1];

            if(cDistane>distances[cNode]) continue;

            for(int[] edge:adList[cNode]){
                int nextNode=edge[0];
                int weight=edge[1];

                if(distances[cNode]+weight<distances[nextNode]){
                    distances[nextNode]=distances[cNode]+weight;
                    pq.add(new int[]{nextNode,distances[nextNode]});

                }
            }
        }

        return distances;
    }
    
}