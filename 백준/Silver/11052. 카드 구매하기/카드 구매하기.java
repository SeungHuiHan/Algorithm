import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int N=sc.nextInt();
        int[] dp=new int[N+1];
        
        int[] P=new int[N+1];
        for(int i=1;i<=N;i++){
            P[i]=sc.nextInt();
        }
        
        for(int i=1;i<=N;i++){
            for(int j=1;j<=i;j++){
                dp[i]=Math.max(dp[i],P[j]+dp[i-j]);
            }
        }
        
        System.out.println(dp[N]);
    }
}