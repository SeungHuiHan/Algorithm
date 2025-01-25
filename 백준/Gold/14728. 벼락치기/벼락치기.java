import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int T=sc.nextInt();

        int[] dp=new int[T+1];
        for(int i=0;i<N;i++){
            int K=sc.nextInt();
            int S=sc.nextInt();

            for(int j=T;j>=K;j--){
                dp[j]=Math.max(dp[j],dp[j-K]+S);
            }

        }

        System.out.println(dp[T]);
    }
}