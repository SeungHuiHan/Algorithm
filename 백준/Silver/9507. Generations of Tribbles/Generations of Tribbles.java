import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        int[] arr=new int[T];
        int max=0;
        for(int i=0;i<T;i++){
            arr[i]=sc.nextInt();
            max=Math.max(max,arr[i]);
        }



        long[] dp=new long[max+1];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for(int i=4;i<=max;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3]+dp[i-4];
        }

        StringBuilder sb=new StringBuilder();
        for(int a:arr){
            sb.append(dp[a]).append("\n");
        }
        System.out.print(sb);

    }
}