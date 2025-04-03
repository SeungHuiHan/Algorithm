import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int N=sc.nextInt();
        int K=sc.nextInt();
        
        int[] dp=new int[N];
        for(int i=0;i<N;i++){
            dp[i]=sc.nextInt();
        }
        
        int start=0;
        long maxTotal=Integer.MIN_VALUE;
        long total=0;
        
        for(int end=0;end<N;end++){
           total+=dp[end];
            
            while(end-start+1>K){
                total-=dp[start];
                start++;
            }
            
            if(end-start+1==K)
                maxTotal=Math.max(maxTotal,total);
            
        }
        
        System.out.println(maxTotal);
        
    }
}