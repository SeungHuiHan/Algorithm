import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st=new StringTokenizer(bf.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());

        int[] arr=new int[N+1];

        st=new StringTokenizer(bf.readLine());
        for(int i=1;i<=N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }


         long[] dp=new long[N+1];
        Arrays.fill(dp,Long.MAX_VALUE);
        dp[1]=0;
         for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                long cost = (long)(i - j) * (1 + Math.abs(arr[i] - arr[j]));
                dp[i] = Math.min(dp[i], Math.max(dp[j], cost));
            }
        }

        System.out.println(dp[N]<=K?"YES":"NO");
    }
}