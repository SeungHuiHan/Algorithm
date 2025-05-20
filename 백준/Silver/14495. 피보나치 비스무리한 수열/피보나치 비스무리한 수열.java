import java.util.*;


public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        if(n==1 ||n==2 ||n==3  ){
            System.out.println(1);
            return;
        }

        long[] dp=new long[n+1];
        dp[1]=1;
        dp[2]=1;
        dp[3]=1;

        for(int i=4;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-3];

        }

        System.out.println(dp[n]);
    }
}