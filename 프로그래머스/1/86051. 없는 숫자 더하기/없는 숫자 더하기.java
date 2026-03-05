import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer =0;
        HashSet<Integer> set=new HashSet<>();
        for(int n:numbers){
            set.add(n);
        }
        
        int ind=0;
        while(ind<=9){
            if(!set.contains(ind)){
                answer+=ind;
            }
            ind++;
        }
        
        return answer;
    }
}