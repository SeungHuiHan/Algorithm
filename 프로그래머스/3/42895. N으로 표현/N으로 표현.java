import java.util.*;
//nn, n+n, n/n, n-n
class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        HashSet<Integer>[] dp = new HashSet[9];  // dp[1] ~ dp[8]
        for (int i = 1; i <= 8; i++) {
            dp[i] = new HashSet<>();
        }
        
        dp[1].add(N);//5
        // dp[2].add(N+N);//5+5
        // dp[2].add(N-N);//5-5
        // dp[2].add(N*10+N);//55
        // dp[2].add(N/N); //5/5
        if (N == number) return 1;
        
        for(int i=2;i<9;i++){
            
            int concat=0;
            for(int j=0;j<i;j++){
                concat=concat*10+N;
            }
            if(concat==number) return i;
            else dp[i].add(concat);
            
            
            for(int j=1;j<i;j++){
                for(int a:dp[j]){
                    for(int b:dp[i-j]){
                        
                        if(a+b==number) return i;
                        else dp[i].add(a+b);
                        if(a-b==number) return i;
                        else dp[i].add(a-b);
                        if(a*b==number) return i;
                        else dp[i].add(a*b);
                        if(b!=0 && a/b==number) return i;
                        else if(b!=0) dp[i].add(a/b);
                    }
                    
                }
            }
        }
        
        return -1;
    }
}