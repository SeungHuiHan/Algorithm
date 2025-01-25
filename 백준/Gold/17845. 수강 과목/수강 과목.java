import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N=sc.nextInt();
        int K=sc.nextInt();

        int[] dp=new int[N+1];

        for(int i=0;i<K;i++){
            int I=sc.nextInt();
            int T=sc.nextInt();

            for(int j=N;j>=T;j--){
                dp[j]=Math.max(dp[j],dp[j-T]+I);
            }
        }

        System.out.println(dp[N]);
    }
}
