import java.util.*;


public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        long[][] dp=new long[N+1][3]; //i자리 수 중, 합을 3으로 나눈 나머지가 r인 경우의 수

        if(N==1){
            System.out.println(0);
            return;
        }

        dp[1][0]=0;
        dp[1][1]=1;
        dp[1][2]=1;

        for(int i=2;i<=N;i++){
            for(int j=0;j<3;j++){
                dp[i][(j+0)%3]=(dp[i][(j+0)%3]+dp[i-1][j])%1000000009;
                dp[i][(j+1)%3]=(dp[i][(j+1)%3]+dp[i-1][j])%1000000009;
                dp[i][(j+2)%3]=(dp[i][(j+2)%3]+dp[i-1][j])%1000000009;
            }

        }


        System.out.println(dp[N][0]);
    }
}