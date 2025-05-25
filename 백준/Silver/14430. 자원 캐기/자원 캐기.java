import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        int[][] arr=new int[N+1][M+1];
        for(int i=1;i<=N;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=1;j<=M;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp=new int[N+1][M+1];

        for(int i=1;i<=N;i++){

            for(int j=1;j<=M;j++){
                if(i==1 && j==1) dp[i][j]=arr[i][j];
                if (i == 1 && j > 1) {
                    dp[i][j] = dp[i][j - 1] + arr[i][j];
                } else if (j == 1 && i > 1) {
                    dp[i][j] = dp[i - 1][j] + arr[i][j];
                } else if (i > 1 && j > 1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
                }
            }
        }

        System.out.println(dp[N][M]);
    }
}