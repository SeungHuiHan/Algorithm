import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int T=sc.nextInt();
        
        for(int i=0;i<T;i++){
            int N=sc.nextInt();
            if(N==1 ||N==2){
                System.out.println(1);
                continue;
            }
            long[] dp=new long[N+1];
            
            
            //dp[0]=0;
            dp[1]=1;
            dp[2]=1;
            for(int j=3;j<=N;j++){
                dp[j]=dp[j-2]+dp[j-3];
            }
            
            System.out.println(dp[N]);
        }
    }
}