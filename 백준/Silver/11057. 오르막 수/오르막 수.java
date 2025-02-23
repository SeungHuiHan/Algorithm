import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] dp = new int[n + 1][10];

        //초기값
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1; //1자리 숫자는 각 숫자 자체가 한가지 경우
        }

        for (int i = 2; i <= n; i++) {
            for (int last = 0; last <= 9; last++) {
                dp[i][last] = 0;
                for (int prev = last; prev <= 9; prev++) {
                    dp[i][last] = (dp[i][last] + dp[i - 1][prev]) % 10007;
                }
            }
        }


        int result = 0;
        for (int i = 0; i < 10; i++) {
            result = (result+dp[n][i]) % 10007;
        }

        System.out.println(result);

    }

    
}