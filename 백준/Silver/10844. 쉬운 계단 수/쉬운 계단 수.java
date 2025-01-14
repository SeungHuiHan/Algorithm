import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        long[][] dp=new long[n+1][9+1];

        for(int digit=1;digit<=9;digit++){
            dp[1][digit]=1;
        }

        for(int i=2;i<=n;i++){
            for(int digit=0;digit<=9;digit++){
                if(digit==0) dp[i][digit]=dp[i-1][1];
                else if(digit==9) dp[i][digit]=dp[i-1][8];
                else{
                    dp[i][digit]=dp[i-1][digit-1]+dp[i-1][digit+1];
                }

                dp[i][digit]%=1000000000;
            }
        }

        long result=0;
        for(int digit=0;digit<=9;digit++){
            result=(result+dp[n][digit])%1000000000;
        }

        System.out.println(result);
    }
}