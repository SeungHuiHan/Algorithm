import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();

        int[][] dp=new int[N+1][3];

        dp[0][0]=1;
        dp[0][1]=0;
        dp[0][2]=0;

        for(int i=1;i<=N;i++){
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2])%9901;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2])%9901;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1])%9901;
        }

        System.out.println((dp[N][0]+dp[N][1]+dp[N][2])%9901);
    }
}