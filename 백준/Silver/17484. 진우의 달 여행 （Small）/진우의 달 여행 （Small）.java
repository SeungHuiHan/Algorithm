import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int[][] arr=new int[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                arr[i][j]=sc.nextInt();
            }
        }



        long[][][] dp=new long[N][M][3];

        // 첫 번째 줄은 방향 제한 없이 초기화
        for(int j = 0; j < M; j++){
            for(int d = 0; d < 3; d++){
                dp[0][j][d] = arr[0][j];
            }
        }

        for(int i=1;i<N;i++){

            for(int j=0;j<M;j++){

                  // 왼쪽 대각선 (↙)
                if (j == 0)
                    dp[i][j][0] = Long.MAX_VALUE;
                else
                    dp[i][j][0] = arr[i][j] + Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]);

                // 수직 (↓)
                dp[i][j][1] = arr[i][j] + Math.min(dp[i - 1][j][0], dp[i - 1][j][2]);

                // 오른쪽 대각선 (↘)
                if (j == M - 1)
                    dp[i][j][2] = Long.MAX_VALUE;
                else
                    dp[i][j][2] = arr[i][j] + Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]);


            }
        }

        long min = Long.MAX_VALUE;
        for (int j = 0; j < M; j++) {
            for (int d = 0; d < 3; d++) {
                min = Math.min(min, dp[N - 1][j][d]);
            }
        }


        System.out.print(min);

    }
}