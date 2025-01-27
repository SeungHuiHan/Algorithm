import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int N=sc.nextInt();
        int M=sc.nextInt();
        int[] dp=new int[N+1];
        
        for(int i=0;i<M;i++){
            int day=sc.nextInt();
            int page=sc.nextInt();
            
            for(int j=N;j>=day;j--){
                dp[j]=Math.max(dp[j],dp[j-day]+page);
            }
        }
        
        System.out.println(dp[N]);
        
    }
}