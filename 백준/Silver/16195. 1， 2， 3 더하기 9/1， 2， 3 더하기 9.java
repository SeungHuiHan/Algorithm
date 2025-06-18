import java.util.*;
import java.io.*;


public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st;
        
        int T=Integer.parseInt(bf.readLine());
        int[][] arr=new int[T][2];
        int max=0;

        for(int i=0;i<T;i++){
            st=new StringTokenizer(bf.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
            max=Math.max(max,arr[i][0]);
        }

        long[][] dp=new long[max+1][max+1];
        dp[0][0]=1;

        for(int i=1;i<=max;i++){
            for(int j=1;j<=i;j++){
                
                if(i - 1 >= 0) dp[i][j] = (dp[i][j] + dp[i - 1][j - 1])%1000000009;
                if(i - 2 >= 0) dp[i][j] = (dp[i][j] + dp[i - 2][j - 1])%1000000009;
                if(i - 3 >= 0) dp[i][j] = (dp[i][j] + dp[i - 3][j - 1])%1000000009;

            }
        }

        for(int i=0;i<T;i++){
            int a=arr[i][0];
            int b=arr[i][1];
            long sum=0;
            for(int j=0;j<=b;j++){
                sum=(sum+dp[a][j])%1000000009;
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}