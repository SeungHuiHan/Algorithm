import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int K=sc.nextInt();
       

        long[][] dp=new long[N+1][K+1];
    //nCn=1, nC0=1
        for(int i=1;i<=N;i++){
            for(int j=0;j<=K;j++){
                if(i==j || j==0) dp[i][j]=1;
                else dp[i][j]=(dp[i-1][j-1]+dp[i-1][j])%10007;
            }
        }
        
        System.out.println(dp[N][K]);

    }
}