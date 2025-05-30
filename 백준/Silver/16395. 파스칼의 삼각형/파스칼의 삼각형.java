import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();


        long[][] dp=new long[n+1][];


        dp[1]=new long[2];
        dp[1][1]=1;

        for(int i=2;i<=n;i++){
            dp[i]=new long[i+1];


            for(int j=1;j<=i;j++){
                if(j==1) dp[i][j]=1;
                else if(j==i) dp[i][j]=1;
                else dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
            }

        }


        System.out.println(dp[n][k]);

    }
}