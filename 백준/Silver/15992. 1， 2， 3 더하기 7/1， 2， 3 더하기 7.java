import java.util.*;
import java.io.*;


public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T=Integer.parseInt(bf.readLine());

        int[] Narr=new int[T];
        int[] Marr=new int[T];
        int max=0;
        for(int i=0;i<T;i++){
            st=new StringTokenizer(bf.readLine());
            Narr[i]=Integer.parseInt(st.nextToken());
            Marr[i]=Integer.parseInt(st.nextToken());
            max=Math.max(max,Narr[i]);
        }

        long[][] dp = new long[max + 1][max + 1];
        dp[0][0] = 1; // 합이 0이고 개수도 0일 때 1가지

        for (int n = 1; n <= max; n++) {
            for (int m = 1; m <= max; m++) {
                if (n >= 1) dp[n][m] = (dp[n][m] + dp[n - 1][m - 1]) % 1000000009;
                if (n >= 2) dp[n][m] = (dp[n][m] + dp[n - 2][m - 1]) % 1000000009;
                if (n >= 3) dp[n][m] = (dp[n][m] + dp[n - 3][m - 1]) % 1000000009;
            }
        }

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<T;i++){
            sb.append(dp[Narr[i]][Marr[i]]).append("\n");
        }
        System.out.println(sb);
    }
}