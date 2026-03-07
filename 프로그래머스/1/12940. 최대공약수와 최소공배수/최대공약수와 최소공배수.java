class Solution {
    public int[] solution(int n, int m) {
        
        int a=0;
        int b=0;
        if(n>m) a=yak(n,m);
        else a=yak(m,n);
        
        b=n*m/a;
        int[] answer = {a,b};
        return answer;
    }
    
    private int yak(int i,int j){
        while(j!=0){
            int r=i%j;
            i=j;
            j=r;
        }
        return i;
    }
    
    
}