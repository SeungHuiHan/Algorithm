import java.util.*;

class Solution {
    private static int [] d;
    private static int nn;
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        nn=n;
        d=new int[rocks.length+2];
        d[0]=0;
        for(int i=1;i<=rocks.length;i++){
            d[i]=rocks[i-1];
        }
        d[d.length-1]=distance;
        
        
        Arrays.sort(d);
        
        int left=0;
        int right=distance;
        
        while(left<=right){
            int mid=(left+right)/2; //최소값
            
            if(canCut(mid)){
                left=mid+1;
               
                answer=mid;
            }else{
                right=mid-1;
            }
        }
        
        return answer;
    }
    
    private static boolean canCut(int mid){
        int count=0;
        int prev=0;
        for(int i=1;i<d.length;i++){
       
            if(d[i]-prev<mid) count++;
            else prev=d[i];
        }
        
        return count<=nn?true:false;
    }
}