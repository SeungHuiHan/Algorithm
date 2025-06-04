import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();

        long[] dp=new long[N+1];

        if(N==0){
            System.out.println(1);
            return;
        }
        dp[0]=1;
        if(N==1){
            System.out.println(1);
            return;
        }
        dp[1]=1;




        for(int i=2;i<=N;i++){
            dp[i]=(dp[i-1]+dp[i-2]+1)%1000000007 ;
        }

        System.out.print(dp[N]);


    }
}