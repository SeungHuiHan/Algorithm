import java.util.*;

public class Main{
    private static long count1=0;
    private static long count2=0;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[] dp=new int[n+1];

        fib(n);

        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<=n;i++){
            count2++;
            dp[i]=dp[i-1]+dp[i-2];
        }

        System.out.println(count1+" "+count2);

    }

    private static int fib(int n){
        if(n==1 || n==2){
            count1++;
            
            return 1;
        }else{
            return fib(n-1)+fib(n-2);
        }
    }
}