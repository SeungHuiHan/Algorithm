import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int A=sc.nextInt();
        int K=sc.nextInt();
        long[] dp=new long[K+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[A]=0;
        
        for(int i=A+1;i<=K;i++){
            if(i%2==0 && i/2>=A){
                dp[i]=Math.min(dp[i],dp[i/2]+1);
            }
            dp[i]=Math.min(dp[i],dp[i-1]+1);
        }

        System.out.println(dp[K]);

    }
}