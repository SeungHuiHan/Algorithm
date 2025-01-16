import java.util.*;

public class Main{
    private static ArrayList<int[]>[] adList;
    private static int[] foods;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int M=sc.nextInt();

        adList=new ArrayList[N+1];
        foods=new int[N+1];

        for(int i=0;i<=N;i++)
            adList[i]=new ArrayList<>();

        Arrays.fill(foods,Integer.MAX_VALUE);


        for(int i=0;i<M;i++){
            int A=sc.nextInt();
            int B=sc.nextInt();
            int C=sc.nextInt();

            adList[A].add(new int[]{B,C});
            adList[B].add(new int[]{A,C});
        }

        daijkstra(1);

        System.out.println(foods[N]);

    }

    private static void daijkstra(int start){
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        pq.add(new int[]{start,0});
        foods[start]=0;

        while(!pq.isEmpty()){
            int[] current=pq.poll();
            int cNode=current[0];
            int cFood=current[1];

            if(cFood>foods[cNode]) continue;

            for(int[] next:adList[cNode]){
                int nextNode=next[0];
                int weight=next[1];

                if(foods[cNode]+ weight<foods[nextNode] ){
                    foods[nextNode]=foods[cNode]+ weight;
                    pq.add(new int[]{nextNode,foods[nextNode]});
                }
            }
        }


    }
}