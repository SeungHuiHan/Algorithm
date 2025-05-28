import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();

        int[][] arr=new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                arr[i][j]=sc.nextInt();
            }
        }

        long[][] dp=new long[N+1][N+1];


        dp[1][1]=1;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(i==N && j==N) continue;
                int jump=arr[i][j];
                if(i+jump<=N){

                    dp[i+jump][j]+=dp[i][j];
                }
                if(j+jump<=N){
                    dp[i][j+jump]+=dp[i][j];
                }
            }

        }

        System.out.println(dp[N][N]);
    }
}