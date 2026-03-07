class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int n=p.length();
        long p1=Long.parseLong(p);
        for(int i=0;i+n<=t.length();i++){
            if(Long.parseLong(t.substring(i,i+n))<=p1) answer++;
        }
        return answer;
    }
}