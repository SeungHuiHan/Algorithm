class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        if(a<b){
            while(a<=b){
                answer+=a;
                a+=1;
            }
        }else if (a>b){
            while(a>=b){
                answer+=b;
                b+=1;
            }
        }else{
            answer=a;
        }
        return answer;
    }
}