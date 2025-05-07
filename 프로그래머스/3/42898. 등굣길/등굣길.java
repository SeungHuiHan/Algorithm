import java.util.*;

//최단 경로의 개수
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] dp=new int[n+1][m+1];
        
        boolean[][] noWork=new boolean[n+1][m+1];
        for(int i=0;i<puddles.length;i++){
            int x=puddles[i][0];
            int y=puddles[i][1];
            
            noWork[y][x]=true;
        }
        
        dp[1][1]=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(i==1 &&j==1) continue;
                if(noWork[i][j]) continue;
                dp[i][j]=(dp[i][j-1]+dp[i-1][j])%1000000007;
                
                
            }
        }
        
        return dp[n][m];
    }
    
    
}