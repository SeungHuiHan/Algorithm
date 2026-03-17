//최소중에 최대
import java.util.*;

class Solution {
    private static int[] arr;
    private static int nn;
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        nn=n;
        arr=new int[rocks.length+1];
        
        for(int i=0;i<rocks.length;i++){
            arr[i]=rocks[i];
        }
        arr[rocks.length]=distance;
        
        Arrays.sort(arr);
        
        int left=0;
        int right=distance;
        
        while(left<=right){
            int mid=(left+right)/2;
            
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
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]-prev<mid) count++;
            else prev=arr[i];
        }
        
        return count<=nn?true:false;
    }
    
    
}