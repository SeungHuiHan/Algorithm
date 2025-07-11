import java.util.*;


public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int M=sc.nextInt();


        long[] dp=new long[N+1];
        dp[0]=1;
        dp[1]=0;

        for(int i=1;i<=N;i++){
            if(M<=i)
                dp[i]=(dp[i-1]+dp[i-M])%1000000007;
            else
                dp[i]=dp[i-1];
        }


        System.out.println(dp[N]);
    }
}