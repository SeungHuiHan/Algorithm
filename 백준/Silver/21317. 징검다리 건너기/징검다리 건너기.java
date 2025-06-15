import java.util.*;


public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();

        int[] small=new int[N+1];
        int[] big=new int[N+1];

        for(int i=1;i<N;i++){
            small[i]=sc.nextInt();
            big[i]=sc.nextInt();
        }

        int veryBig=sc.nextInt();


        int[][] dp=new int[N+1][2]; //0:veryBig점프를 사용 안함, 1: veryBig점프를 사용함
        for(int i=1;i<=N;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }

        dp[1][0]=0;
        dp[1][1]=0;

        for(int i=1;i<N;i++){
            if(i+1<=N){
                dp[i+1][0]=Math.min(dp[i+1][0],dp[i][0]+small[i]);
                dp[i+1][1]=Math.min(dp[i+1][1],dp[i][1]+small[i]);
            }
            if(i+2<=N){
                dp[i+2][0]=Math.min(dp[i+2][0],dp[i][0]+big[i]);
                dp[i+2][1]=Math.min(dp[i+2][1],dp[i][1]+big[i]);
            }
            if(i+3<=N){
                dp[i+3][1]=Math.min(dp[i+3][1],dp[i][0]+veryBig);
            }


        }

        System.out.println(Math.min(dp[N][0],dp[N][1]));
    }
}