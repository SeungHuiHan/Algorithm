import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        
        for(int i=0;i<arr.length;i++){
            if(dq.isEmpty()) dq.offer(arr[i]);
            else{
                if(arr[i-1]!=arr[i]) dq.offer(arr[i]);
               
            }
        }
        int[] answer = new int[dq.size()];
        for(int i=0;i<answer.length;i++){
            answer[i]=dq.poll();
        }

        return answer;
    }
}