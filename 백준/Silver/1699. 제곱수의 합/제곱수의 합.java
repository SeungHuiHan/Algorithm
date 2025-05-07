import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        boolean[] xx=new boolean[N+1];
        for(int i=1;i*i<=N;i++){
            xx[i]=true;
        }
        int[]dp=new int[N+1];
        for(int i=1;i<=N;i++){
            dp[i]=i; // 초기화
        }

        for(int i=2;i<=N;i++){
            for(int j=1;j*j<=i;j++){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }

        System.out.println(dp[N]);

    }
}