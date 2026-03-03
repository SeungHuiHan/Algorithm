class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        
        int len=arr.length;
        int sum=0;
        for(int a:arr)
            sum+=a;
        return (double)sum/len;
    }
}