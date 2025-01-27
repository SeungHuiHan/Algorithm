import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int[] dp=new int[101];
        int[] L=new int[N+1];
        int[] J=new int[N+1];

        for(int i=1;i<=N;i++){
            L[i]=sc.nextInt();
        }
        for(int i=1;i<=N;i++){
            J[i]=sc.nextInt();
        }

        for(int i=1;i<=N;i++){

            for(int j=100;j>=L[i];j--){
                dp[j]=Math.max(dp[j],dp[j-L[i]]+J[i]);
            }
        }
        System.out.println(dp[99]);

    }
}