import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int T=sc.nextInt();
        for(int i=0;i<T;i++){
            int k=sc.nextInt();
            int n=sc.nextInt();
            int[][] dp=new int[k+1][n+1];//0층

            for(int j=1;j<=n;j++){
                dp[0][j]=j;
            }

            //dp 계산
            for(int j=1;j<=k;j++){
                for(int l=1;l<=n;l++){
                    dp[j][l]=dp[j-1][l]+dp[j][l-1];
                }
            }


            System.out.println(dp[k][n]);
        }
    }
}