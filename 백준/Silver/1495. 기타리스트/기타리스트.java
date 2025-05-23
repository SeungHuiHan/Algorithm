import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int S=sc.nextInt();
        int M=sc.nextInt();
        int[] arr=new int[N+1];

        for(int i=1;i<=N;i++){
            arr[i]=sc.nextInt();
        }
        boolean[][] dp=new boolean[N+1][M+1];
        dp[0][S]=true;

        for(int i=1;i<=N;i++){
            for(int j=0;j<=M;j++){

                if(dp[i-1][j]){
                    if(j-arr[i]>=0){
                        dp[i][j-arr[i]]=true;
                    }

                    if(j+arr[i]<=M){
                        dp[i][j+arr[i]]=true;

                    }
                }
            }


        }



        for(int i=M;i>=0;i--){
            if(dp[N][i]){
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);
    }
}