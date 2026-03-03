class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int a=2;
        while(n%a!=1){
            a+=1;
        }
        return a;
    }
}