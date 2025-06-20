import java.util.*;


public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        int code1=fib(n);
        int code2=fibonacci(n);


        System.out.println(code1+" "+code2);
    }


    private static int  fib(int n){
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=1;

        for(int i=3;i<=n;i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;

        }

        return dp[n];
    }

    private static int  fibonacci(int n){
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=1;
        int countDP=0;

        for(int i=3;i<=n;i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
            countDP=(countDP+1)% 1000000007;;
        }

        return countDP;
    }
    
}