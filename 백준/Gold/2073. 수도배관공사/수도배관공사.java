import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int D=sc.nextInt(); //강의 거리
        int P=sc.nextInt(); //파이프 개수
        int[] dp=new int[D+1];

        for(int i=1;i<=D;i++){
            dp[i]=-1;
        }
        dp[0]=Integer.MAX_VALUE;

        for(int i=0;i<P;i++){
            int L=sc.nextInt();
            int C=sc.nextInt();

            for(int j=D;j>=L;j--){
                if(dp[j-L]!=-1){
                    int minCapacity=Math.min(dp[j-L],C);
                    dp[j]=Math.max(dp[j],minCapacity);
                }

            }
        }

        System.out.println(dp[D]);
    }
}