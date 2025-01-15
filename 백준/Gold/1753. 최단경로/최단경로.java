import java.util.*;

public class Main{
    private static List<int []>[] adList;
    private static int[] distances;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int V=sc.nextInt();
        int E=sc.nextInt();
        int K=sc.nextInt();

        adList=new ArrayList[V+1];
        distances=new int[V+1];

        for(int i=0;i<=V;i++){
            adList[i]=new ArrayList<>();
        }
        Arrays.fill(distances,Integer.MAX_VALUE);

        for(int i=0;i<E;i++){
            int start=sc.nextInt();
            int end=sc.nextInt();
            int weight=sc.nextInt();

            adList[start].add(new int[]{end,weight});
        }

        dijkstra(K, V);

        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=V;i++){
           if(distances[i]==Integer.MAX_VALUE){
               sb.append("INF").append("\n");
           }else{
               sb.append(distances[i]).append("\n");
           }
        }

        System.out.println(sb.toString());

    }

    private static void dijkstra(int start, int V){
        PriorityQueue<int []> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[1]));

        distances[start]=0;
        pq.add(new int[]{start,0});

        while(!pq.isEmpty()){
            int[] current=pq.poll();
            int cNode=current[0];
            int cDistance=current[1];

            if(cDistance>distances[cNode]) continue;

            for(int[] edge:adList[cNode]){
                int nextNode=edge[0];
                int weight=edge[1];

                if(distances[cNode]+weight<distances[nextNode]){
                    distances[nextNode]=distances[cNode]+weight;
                    pq.add(new int[]{nextNode,distances[nextNode]});
                }
            }
        }

    }
    
}