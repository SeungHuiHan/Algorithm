import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[] dp;
        if(n>0){
            dp=new int[n+2];
            dp[0]=0;
            dp[1]=1;
            for(int i=2;i<=n;i++){
                dp[i]=(dp[i-1]+dp[i-2])%1000000000;
            }

        }else{
            n=-n;
            dp=new int[n+2];
            dp[0]=0;
            dp[1]=1;
            for(int i=2;i<=n;i++){
                dp[i]=(dp[i-2]-dp[i-1])%1000000000;
            }
        }



        if(dp[n]>0){
            System.out.println(1);
            System.out.println(dp[n]);
        }else if(dp[n]==0){
            System.out.println(0);
            System.out.println(0);
        }else if(dp[n]<0){
            System.out.println(-1);
            System.out.println(-dp[n]);
        }

    }
}