import java.util.*;

public class Main {
    private static ArrayList<int[]>[] adList;
    private static boolean[] visited;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int M=sc.nextInt();

        visited=new boolean[N+1];
        adList=new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            adList[i]=new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();

            adList[a].add(new int[]{b,c});
            adList[b].add(new int[]{a,c});
        }

        System.out.println(bfsPlusDfs(1));
    }


    private static int bfsPlusDfs(int start){
        PriorityQueue<int[]> queue=new PriorityQueue<>(Comparator.comparing(a->a[1]));
        queue.add(new int[]{start,0});

        int  minCost=0; //최소비용
        int connectCount=0; //연결 노드 개수

        while(!queue.isEmpty()){
            int[] current=queue.poll();
            int node=current[0];
            int weight=current[1];

            if(visited[node]) continue;
            else visited[node]=true;
            minCost+=weight; //최소비용 합
            connectCount++; //연결 노드

            if(connectCount==adList.length-1) break;

            for(int[] next:adList[node]){
                if(!visited[next[0]])
                    queue.add(new int[]{next[0],next[1]});
            }
        }

        return minCost;

    }
}
