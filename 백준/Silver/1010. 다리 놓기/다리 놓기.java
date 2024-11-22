import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int T=sc.nextInt();
        int[][] dp=new int[30][30];
        
        for(int i=0;i<30;i++){
            dp[i][0]=1;
            dp[i][i]=1;
        }

        for(int n=1;n<30;n++){
            for(int k=1;k<n;k++){
                dp[n][k]=dp[n-1][k-1]+dp[n-1][k];
            }           
        }
        
        for(int i=0;i<T;i++){
            int N=sc.nextInt();
            int M=sc.nextInt();
            System.out.println(dp[M][N]);
        }
    }
    
}