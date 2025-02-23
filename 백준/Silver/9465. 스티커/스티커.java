import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int T=sc.nextInt();
        for(int t=0;t<T;t++){
            int n=sc.nextInt();

            //dp[n][0] n열에서 위쪽 스티커를 선택시 최대 점수
            //dp[n][1] n열에서 아래쪽 스티커를 선택시 최대 점수
            int[][] dp=new int[n+1][2];

            //stickers[0][n] n열의 위쪽 스티커,
            //stickers[1][n] n열의 아래쪽 스티커
            int[][] stickers=new int[3][n+1];


            for(int j=0;j<2;j++){
                for(int k=1;k<=n;k++){
                    stickers[j][k]=sc.nextInt();
                }
            }
            dp[0][0]=stickers[0][0];
            dp[0][1]=stickers[1][0];
            dp[1][0]=stickers[0][1]+dp[0][1];
            dp[1][1]=stickers[1][1]+dp[0][0];

            for(int i=2;i<=n;i++){
                dp[i][0]=Math.max(dp[i-1][1],dp[i-2][1])+stickers[0][i];
                dp[i][1]=Math.max(dp[i-1][0],dp[i-2][0])+stickers[1][i];
            }

            System.out.println(Math.max(dp[n][0],dp[n][1]));
        }
    }
}