import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<T;i++){
            int N=sc.nextInt();
            int[] arr=new int[N];

            for(int j=0;j<N;j++){
                arr[j]=sc.nextInt();
            }

            long[] dp=new long[N];
            long max=arr[0];
            dp[0]=arr[0];

            for(int j=1;j<N;j++){
                dp[j]=Math.max(arr[j],dp[j-1]+arr[j]);

                max=Math.max(max,dp[j]);
            }
            sb.append(max).append("\n");

        }

        System.out.print(sb);

    }
}