import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int K=sc.nextInt();

        int[] dp=new int[N+K];

        for(int i=0;i<N;i++){
            dp[i]=sc.nextInt();
        }

        for(int i=N;i<N+K;i++){
            dp[i]=dp[i-N];
        }

        int maxSum=0;
        int start=0;
        int total=0;

        for(int end=0;end<N+K;end++){
            total+=dp[end];

            if(end-start+1==K){
                maxSum=Math.max(maxSum,total);
                total-=dp[start];
                start++;
            }
        }

        System.out.println(maxSum);
    }
}