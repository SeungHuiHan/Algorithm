import java.util.*;

public class Main{
    private static ArrayList<Integer>[] adList;
    private static boolean[] visited;
    private static int N,M,count;
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        N=sc.nextInt();
        M=sc.nextInt();
        
        adList=new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            adList[i]=new ArrayList<>();
        }
        visited=new boolean[N+1];
        
        for(int i=0;i<M;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            
            adList[a].add(b);
            adList[b].add(a);
        }
        
        dfs(1);
        
        System.out.println(count);
    }
    
    private static void dfs(int start){
        visited[start]=true;
        
        for(int next:adList[start]){
            if(!visited[next]){
                count++;
                dfs(next);
            }
        }
    }
}