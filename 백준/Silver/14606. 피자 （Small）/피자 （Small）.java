import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();

        long[] dp=new long[N+1];

        if(N==1){
            System.out.println(0);
            return;
        }
        dp[1]=0;
        if(N==2){
            System.out.println(1);
            return;
        }
        dp[2]=1;

        if(N==3){
            System.out.println(3);
            return;
        }
        dp[3]=3;
        //4=2*2=4
        //2=1*1=1 2
        //


        for(int i=4;i<=N;i++){
            for(int j=1;j<=i;j++){
                dp[i]=Math.max(dp[i],dp[j]+dp[i-j]+j*(i-j));
            }
        }

        System.out.print(dp[N]);

    }
}