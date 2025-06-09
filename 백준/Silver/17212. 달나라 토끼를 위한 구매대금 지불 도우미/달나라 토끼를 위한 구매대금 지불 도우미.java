import java.util.*;


public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();


        long[] dp=new long[N+1];
        Arrays.fill(dp,Integer.MAX_VALUE);

       
        int[] coins=new int[]{1,2,5,7};
          dp[0]=0;
        for(int i=1;i<=N;i++){
            
            for(int coin:coins){
                if(i-coin>=0 &&dp[i-coin]!=Long.MAX_VALUE ){
                    dp[i]=Math.min(dp[i],dp[i-coin]+1);
                }
            }

        }
        System.out.println(dp[N]);
    }
}