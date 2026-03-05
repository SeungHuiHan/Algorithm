class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr=s.split("");
        
        int n=s.length();
        if(n%2==0)
            answer=arr[n/2-1]+arr[n/2];
        else answer=arr[n/2];
        return answer;
    }
}