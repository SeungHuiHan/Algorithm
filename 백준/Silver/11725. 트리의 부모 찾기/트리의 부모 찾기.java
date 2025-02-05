import java.util.*;

public class Main{
    private static ArrayList<Integer>[] tree;
    private static boolean[] visited;
    private static int[] parent;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        parent=new int[N+1];
        visited=new boolean[N+1];

        tree=new ArrayList[N+1];

        for(int i=0;i<=N;i++)
            tree[i]=new ArrayList<>();

        for(int i=0;i<N-1;i++){
            int node1=sc.nextInt();
            int node2=sc.nextInt();

            tree[node1].add(node2);
            tree[node2].add(node1);
        }

        dfs(1);

        for(int i=2;i<=N;i++)
            System.out.println(parent[i]);
    }

    private static void dfs(int now){
        visited[now]=true;

        for(int next:tree[now]){
            if(!visited[next]){
                parent[next]=now;
                dfs(next);
            }
        }
    }
}