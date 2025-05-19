import java.util.*;
import java.math.BigInteger;


public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int H=sc.nextInt();
        int Y=sc.nextInt();

        if(Y==0){
            System.out.println(H);
            return;
        }

        long[] dp=new long[Y+1];
        dp[0]=H;

        for(int i=1;i<=Y;i++){
            // 1년 단리 (5%)
            dp[i] = Math.max(dp[i], (long)(dp[i - 1] * 1.05));

            // 3년 복리 (20%)
            if (i >= 3) {
                dp[i] = Math.max(dp[i], (long)(dp[i - 3] * 1.20));
            }

            // 5년 복리 (35%)
            if (i >= 5) {
                dp[i] = Math.max(dp[i], (long)(dp[i - 5] * 1.35));
            }

        }

        System.out.println(dp[Y]);
    }
}