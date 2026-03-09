import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> pmap=new HashMap<>();
        HashMap<String,Integer> cmap=new HashMap<>();
        for(String p:participant){
            if(pmap.containsKey(p)){
                pmap.put(p,pmap.get(p)+1);
            }else
                pmap.put(p,1);
        }
        
        for(String c:completion){
            if(cmap.containsKey(c)){
                cmap.put(c,cmap.get(c)+1);
            }else
                cmap.put(c,1);
        }
        
        for(String p:participant){
            if(!cmap.containsKey(p)) return p;
            if(pmap.get(p)>cmap.get(p)) return p;
        }
        return answer;
    }
}