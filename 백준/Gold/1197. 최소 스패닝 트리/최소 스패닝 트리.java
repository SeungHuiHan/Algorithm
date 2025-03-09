import java.util.*;

public class Main{
    private static ArrayList<int[]>[] adList;
    private static boolean[] visited;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int V=sc.nextInt();
        int E=sc.nextInt();

        visited=new boolean[V+1];
        adList=new ArrayList[V+1];

        for(int i=0;i<=V;i++){
            adList[i]=new ArrayList<>();
        }

        for(int i=0;i<E;i++){
            int A=sc.nextInt();
            int B=sc.nextInt();
            int C=sc.nextInt();

            adList[A].add(new int[]{B,C});
            adList[B].add(new int[]{A,C});
        }

        System.out.println(spanningTree(1));
    }

    private static int spanningTree(int start){
        PriorityQueue<int[] > queue=new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        queue.add(new int[]{start,0});
        //visited[start]=true;

        int minWeight=0;
        int depth=0;

        while(!queue.isEmpty()){
            int[] current=queue.poll();
            int node=current[0];
            int weight=current[1];

            if(visited[node]) continue;
            else visited[node]=true;
            minWeight+=weight;
            depth++;

            if(depth==adList.length-1) break;

            for(int[] next:adList[node]){
                if(!visited[next[0]]){
                    queue.add(new int[]{next[0],next[1]});
                }
            }
        }
        return  minWeight;
    }
}