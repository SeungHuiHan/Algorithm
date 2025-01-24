import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int T=sc.nextInt();

        for(int i=0;i<T;i++){
            int N=sc.nextInt();

            int[] coins=new int[N+1];
            for(int j=1;j<=N;j++){
                coins[j]=sc.nextInt();
            }

            int M=sc.nextInt();
            int[] dp=new int[M+1];

            dp[0]=1;

            for(int j=1;j<=N;j++){
                for(int k=coins[j];k<=M;k++){
                   dp[k]=dp[k]+dp[k-coins[j]];
                }
            }

            System.out.println(dp[M]);
        }
    }
}