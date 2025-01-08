import java.util.*;

public class Main{
  private static List<Integer>[] adList;
    private static boolean[] visited;
    private static int[] parent;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();

        visited=new boolean[N];
        parent=new int[N];

        adList=new ArrayList[N];
        for(int i=0;i<N;i++){
            adList[i]=new ArrayList<>();
        }

        int root=-1;
        for(int i=0;i<N;i++){
            parent[i]=sc.nextInt();
            if(parent[i]==-1) {
                root=i;
            }else{
                adList[parent[i]].add(i);
            }
        }

        int M=sc.nextInt();
        if(M==root){
            System.out.println(0);
            return;
        }

        dfs(M);
        adList[parent[M]].remove(adList[parent[M]].indexOf(M));
        
        int leafCount=0;
        for(int i=0;i<N;i++){
            if(adList[i].isEmpty() && !visited[i]) leafCount++;
        }

        System.out.println(leafCount);
    }

    private static void dfs(int now){
        visited[now]=true;

        for(int next:adList[now]){
            if(!visited[next]){
                dfs(next);
            }
        }
        
    }
}