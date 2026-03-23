import java.util.*;

public class Main{

    private static boolean[] visited;
    private static ArrayDeque<Integer> dq=new ArrayDeque<>(); //bfs
    private static ArrayList<Integer>[] adList; //dfs
    private static int N,M,V;
    private static StringBuilder sb=new StringBuilder();
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        V=sc.nextInt();
        
        visited=new boolean[N+1];
        adList=new ArrayList[N+1];
        for(int i=0;i<=N;i++){
            adList[i]=new ArrayList<>();
        }
        
        for(int i=0;i<M;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            adList[x].add(y);
            adList[y].add(x);
        }
        
        for(int i=0;i<=N;i++){
            Collections.sort(adList[i]);
        }
        
        
        dfs(V);
        sb.append("\n");
        visited=new boolean[N+1];
        bfs(V);
        
        System.out.println(sb.toString());
    }
    
    private static void dfs(int start){
        visited[start]=true;
        sb.append(start+" ");
        
        for(int next:adList[start]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
    
    private static void bfs(int start){
        dq.offer(start);
        visited[start]=true;
        
        while(!dq.isEmpty()){
            int n=dq.poll();
            sb.append(n+" ");
            
            for(int next:adList[n]){
                if(!visited[next]){
                    dq.offer(next);
                    visited[next]=true;
                    
                }
            }
            
        }
    }
}