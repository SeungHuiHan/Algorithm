import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();

        int[] dp=new int[N+1];
        int[] route=new int[N+1]; //추적


        if(N==1){
            System.out.println(0);
            System.out.println(1);
            return;
        }
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[1]=0;


        for(int i=2;i<=N;i++){
            if(i%3==0 && dp[i]>dp[i/3]+1){
                dp[i]=dp[i/3]+1;
                route[i]=i/3;
            }

            if(i%2==0 && dp[i]>dp[i/2]+1){
                dp[i]=dp[i/2]+1;
                route[i]=i/2;
            }

            if( dp[i]>dp[i-1]+1){
                dp[i]=dp[i-1]+1;
                route[i]=i-1;
            }


        }

        StringBuilder sb=new StringBuilder();
        sb.append(dp[N]).append("\n");
        int current=N;
        while(current!=0){
            sb.append(current+" ");
            current=route[current];
        }

        System.out.print(sb);


    }
}