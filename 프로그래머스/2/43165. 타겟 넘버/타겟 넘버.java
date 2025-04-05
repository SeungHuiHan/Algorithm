import java.util.*;

class Solution {
    
    private static int answer=0;
    public int solution(int[] numbers, int target) {
        
        
        backtracking(0,0,numbers,target);
        
        return answer;
    }
    
    private static void backtracking(int sum,int count,int[] numbers,int target){
        if(count==numbers.length){
            if(sum==target) answer++;
            return ;
        }
        
        
       backtracking(sum+numbers[count],count+1,numbers,target);
       backtracking(sum-numbers[count],count+1,numbers,target);
        
    }
}