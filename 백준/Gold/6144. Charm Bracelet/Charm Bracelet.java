import java.util.*;

public class Main{
    public static void main(String[] agrs){
        Scanner sc=new Scanner(System.in);
        
        int N=sc.nextInt();
        int M=sc.nextInt();
        
        int[] dp=new int[M+1];
        
        for(int i=0;i<N;i++){
            int w=sc.nextInt();
            int d=sc.nextInt();
            
            for(int j=M;j>=w;j--){
                dp[j]=Math.max(dp[j],dp[j-w]+d);
            }
        }
        
        System.out.println(dp[M]);
    }
}