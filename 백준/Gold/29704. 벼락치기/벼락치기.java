import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int T=sc.nextInt();

        int[] dp=new int[T+1];

        int sum=0;
        for(int i=0;i<N;i++){
            int d=sc.nextInt();
            int m=sc.nextInt();
            sum+=m;

            for(int j=T;j>=d;j--){
                dp[j]=Math.max(dp[j],dp[j-d]+m);
            }

        }

        System.out.println(sum-dp[T]);
    }
}