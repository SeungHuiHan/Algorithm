import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int R=sc.nextInt();
        int C=sc.nextInt();
        int W=sc.nextInt();


        long[][] dp=new long[R+W+1][R+W+1];


        dp[1][1]=1;
        for(int i=2;i<=R+W;i++){
            for(int j=1;j<=i;j++){
                dp[i][j]=dp[i-1][j-1]+dp[i-1][j];

            }
        }

        long sum=0;
        for(int i=R;i<R+W;i++){
            for(int j=C;j<=C+i-R;j++){
                sum+=dp[i][j];
            }
        }

        System.out.println(sum);

    }

  
}