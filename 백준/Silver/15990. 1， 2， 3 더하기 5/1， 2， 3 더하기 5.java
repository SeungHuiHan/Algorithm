import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int T=sc.nextInt();
        int[] arr=new int[T];
        int max=0;
        for(int i=0;i<T;i++){
            arr[i]=sc.nextInt();

            max=Math.max(max,arr[i]);
        }
        int[][] dp=new int[max+1][4];

        if (max >= 1) dp[1][1] = 1; // 1
        if (max >= 2) dp[2][2] = 1; // 2
        if (max >= 3) {
            dp[3][1] = 1; // 2 + 1
            dp[3][2] = 1; // 1 + 2
            dp[3][3] = 1; // 3
        }


        for (int i = 4; i <= max; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % 1000000009;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % 1000000009;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % 1000000009;
        }


        StringBuilder sb=new StringBuilder();
        for(int a:arr){
            long sum=0;
            sum=(sum+dp[a][1])%1000000009;
            sum=(sum+dp[a][2])%1000000009;
            sum=(sum+dp[a][3])%1000000009;
            
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}