class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int p=0;
        int y=0;
        
        for(int i=0;i<s.length();i++){
            char c=Character.toUpperCase(s.charAt(i));
            
            if(c=='P') p++;
            else if(c=='Y') y++;
        }

        return (p==y)?true:false;
    }
}