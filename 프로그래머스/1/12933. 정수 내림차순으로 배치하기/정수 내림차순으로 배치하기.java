import java.util.*;

class Solution {
    public long solution(long n) {
   
        String[] arr=String.valueOf(n).split("");
        
        Arrays.sort(arr,Collections.reverseOrder());
        String s=String.join("",arr);
        long answer=Long.parseLong(s);
        return answer;
    }
}