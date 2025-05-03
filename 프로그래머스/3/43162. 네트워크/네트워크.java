import java.util.*;

class Solution {
    private static ArrayList<Integer>[] adList;
    private static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        adList=new ArrayList[n];
        visited=new boolean[n];
        
        for(int i=0;i<n;i++){
            adList[i]=new ArrayList<>();
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && computers[i][j]==1){
                    adList[i].add(j);
                }
            }
        }
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    private static void dfs(int now){
        visited[now]=true;
        
        for(int next:adList[now]){
            if(!visited[next])
                dfs(next);
        }
    }
}