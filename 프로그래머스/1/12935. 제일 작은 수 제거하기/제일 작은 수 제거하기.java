import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        
        if(arr.length==1 ) return new int[]{-1};
        ArrayList<Integer> list=new ArrayList<>();
        ArrayList<Integer> list1=new ArrayList<>();
        for(int i:arr){
            list.add(i);
            list1.add(i);
        }
        
        Collections.sort(list);
        int s=list.get(0);
        
        for(int i=0;i<list1.size();i++){
            if(list1.get(i)==s) {
                list1.remove(i);
                i--;
            }
        }
        int[] answer = new int[list1.size()];
        for(int i=0;i<list1.size();i++){
            answer[i]=list1.get(i);
        }
        return answer;
    }
}