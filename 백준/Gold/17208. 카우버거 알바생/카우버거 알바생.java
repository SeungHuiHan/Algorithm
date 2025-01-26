import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int N=sc.nextInt();
        int M=sc.nextInt();
        int K=sc.nextInt();
        
        int[][] dp=new int[M+1][K+1];
        int[][] orders=new int[N+1][2];
        
        for(int i=1;i<=N;i++){
            orders[i][0]=sc.nextInt(); //치즈버거 요구 개수
            orders[i][1]=sc.nextInt(); //감자튀김 요구 개수
        }
        
        for(int i=1;i<=N;i++){
            int burger=orders[i][0];
            int fries=orders[i][1];
            
            if(M>=burger && K>=fries){
                for(int j=M;j>=burger;j--){
                    for(int k=K;k>=fries;k--){
                        dp[j][k]=Math.max(dp[j][k],dp[j-burger][k-fries]+1);
                    }
                }
            }
            
        }
        
        System.out.println(dp[M][K]);
    }
}