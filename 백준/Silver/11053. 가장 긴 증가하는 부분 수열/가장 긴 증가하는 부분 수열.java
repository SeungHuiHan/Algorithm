import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int[] dp=new int[N+1];
        int[] A=new int[N+1];

        Arrays.fill(dp,1);

        for(int i=1;i<=N;i++){
            A[i]=sc.nextInt();
        }

        for(int i=2;i<=N;i++){
            for(int j=1;j<i;j++){
                if(A[i]>A[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }

        int maxLength=0;
        for(int i=1;i<=N;i++){
            maxLength=Math.max(maxLength,dp[i]);
        }

        System.out.println(maxLength);
        
    }
}