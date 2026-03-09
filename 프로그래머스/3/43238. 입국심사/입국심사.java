import java.util.*;

class Solution {
    
    private static int nn;
    private static int[] timess;
    public long solution(int n, int[] times) {
        long answer = 0;
        nn=n;
        timess=times;
        
        long max=0;
        for(int t:times){
            max=Math.max(max,t);
        }
        long left=0;
        long right= max*n;
        
        while(left<=right){
            long mid=(left+right)/2;
            
            if(canCut(mid)){
                answer=mid;
                right=mid-1;
            }else{
                left=mid+1;
                
            }
        }
        return answer;
    }
    
    private static boolean canCut(long mid){
        long sum=0;
        for(int time:timess){
            sum+=mid/time;
        }
        return sum>=nn?true:false;
    }
}