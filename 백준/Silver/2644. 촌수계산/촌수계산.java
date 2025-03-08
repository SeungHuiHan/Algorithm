import java.util.*;

public class Main{
    private static ArrayList<Integer>[] adList;
    private static boolean[] visited;
    private static int target1,target2;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        target1=sc.nextInt();
        target2=sc.nextInt();

        int m=sc.nextInt();
        visited=new boolean[n+1];

        adList=new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            adList[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            int parent=sc.nextInt();
            int child=sc.nextInt();

            adList[parent].add(child);
            adList[child].add(parent);
        }

        System.out.println(bfs(target1));

    }


    private static int bfs(int target){
        ArrayDeque<int[]> queue=new ArrayDeque<>();
        queue.add(new int[]{target,0});
        visited[target]=true;

        while (!queue.isEmpty()){
            int[] current=queue.poll();
            int node=current[0];
            int depth=current[1];


            if(node==target2) return depth;

            for(int next:adList[node]){
                if(!visited[next]){
                    visited[next]=true;
                    queue.add(new int[]{next,depth+1});


                }
            }
        }

        return -1;
    }
}