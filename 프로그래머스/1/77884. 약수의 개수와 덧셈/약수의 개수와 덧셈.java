import java.util.*;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        int[] dp=new int[right+1];
       
       
        for(int i=1;i<=right;i++){
            for(int j=i;j<=right;j+=i)
                dp[j]++;
        }
        
        for(int i=left;i<=right;i++){
            if(dp[i]%2==0) answer+=i;
            else  answer-=i;
        }
        
        return answer;
    }
}