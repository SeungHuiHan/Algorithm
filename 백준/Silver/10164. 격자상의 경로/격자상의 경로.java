import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int K=sc.nextInt();


        long[][] dp=new long[N+1][M+1];


        int kx=0;
        int ky=0;
        if (K != 0) {
            kx = (K - 1) / M + 1;
            ky = (K - 1) % M + 1;
        }

        dp[1][1]=1;

        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                if(i==1 && j==1) continue ;

                if(i>1) dp[i][j]+=dp[i-1][j];
                if(j>1) dp[i][j]+=dp[i][j-1];

            }

        }

        if(K==0){
            System.out.println(dp[N][M]);
            return;
        }
        long dp1 = dp[kx][ky];

        dp=new long[N+1][M+1];
        dp[kx][ky]=1;
        for(int i=kx;i<=N;i++){
            for(int j=ky;j<=M;j++){
                if(i>1) dp[i][j]+=dp[i-1][j];
                if(j>1) dp[i][j]+=dp[i][j-1];
            }

        }

        System.out.println(dp1*dp[N][M]);
        
    }
}