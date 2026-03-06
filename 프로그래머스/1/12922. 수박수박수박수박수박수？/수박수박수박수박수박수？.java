class Solution {
    public String solution(int n) {
        String answer = "";
        
        if(n==1) return "수";
        if(n%2==0) return "수박".repeat(n/2);
        if(n%2==1) return "수박".repeat(n/2)+"수";
        return answer;
    }
}