import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        int max=0;
        for(int i=0;i<times.length;i++){
            max=Math.max(max,times[i]);
        }
        
        long left=1;
        long right=max*(long)n;
        
        while(left<=right){
            long mid=(left+right)/2;
            
            if(canCut(times,mid,n)){
                answer=mid;
                right=mid-1;
            }else{
                left=mid+1;
                
            }
        }
        return answer;
    }
    
    private static boolean canCut(int[] times,long mid,int n){
        long count=0;
        
        for(int time:times){
            count+=mid/time;
        }
        return count>=n;
    }
}