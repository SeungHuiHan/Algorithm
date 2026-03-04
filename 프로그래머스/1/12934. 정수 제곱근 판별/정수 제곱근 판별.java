import java.math.*;


class Solution {
    public long solution(long n) {
        long answer = 0;
        
        long z=(long)Math.sqrt(n);
        if(z*z==n)
            return (z+1)*(z+1);
        else
            return -1;
        
        
    }
}