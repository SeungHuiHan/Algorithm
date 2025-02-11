import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int x=sc.nextInt();

        int[] dp=new int[x+1];
        dp[0]=1;

        for(int i=0;i<N;i++){
            int l=sc.nextInt();
            int c=sc.nextInt();

            for(int j=x;j>=l;j--){
                for (int k = 1; k <= c && j >= k * l; k++) {
                    dp[j] += dp[j - k * l];
                }
            }
        }

        System.out.println(dp[x]);
    }
}