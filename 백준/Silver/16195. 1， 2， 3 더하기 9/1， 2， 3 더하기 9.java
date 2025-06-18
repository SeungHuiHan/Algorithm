import java.util.*;
import java.io.*;


public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

         int T = Integer.parseInt(bf.readLine());
        int[][] arr = new int[T][2];
        int maxN = 0;
        int maxM = 0;

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // n
            arr[i][1] = Integer.parseInt(st.nextToken()); // m
            maxN = Math.max(maxN, arr[i][0]);
            maxM = Math.max(maxM, arr[i][1]);
        }

        // dp[i][j] = i를 j개의 수로 만드는 방법의 수
        long[][] dp = new long[maxN+1][maxM+1];
        dp[0][0] = 1;

        for(int i = 1; i <= maxN; i++){
            for(int j = 1; j <= maxM; j++){
                for(int k = 1; k <= 3; k++){
                    if(i - k >= 0){
                        dp[i][j] = (dp[i][j] + dp[i - k][j - 1]) % 1000000009;
                    }
                }
            }
        }

        for(int i = 0; i < T; i++){
            int n = arr[i][0];
            int m = arr[i][1];
            long result = 0;
            for(int j = 1; j <= m; j++){
                result = (result + dp[n][j]) % 1000000009;
            }
            sb.append(result).append("\n");
        }
        

        System.out.println(sb);
    }
}