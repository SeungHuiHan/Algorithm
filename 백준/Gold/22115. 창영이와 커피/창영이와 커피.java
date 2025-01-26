import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int K=sc.nextInt();

        int[] dp=new int[K+1];

        for(int i=1;i<=K;i++){
            dp[i]=Integer.MAX_VALUE; //초기화, 아직 계산안함
        }
        dp[0]=0;  // 카페인 0을 섭취하는 데 필요한 커피 개수는 0개

        for(int i=1;i<=N;i++){
            int C=sc.nextInt();

            for(int j=K;j>=C;j--){
                if(dp[j-C]!=Integer.MAX_VALUE){
                    dp[j]=Math.min(dp[j],dp[j-C]+1);
                }
            }


        }

        System.out.println(dp[K]==Integer.MAX_VALUE?-1:dp[K]);

        
        
    }
}