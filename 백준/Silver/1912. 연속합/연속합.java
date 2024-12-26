import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);

        int n=sc.nextInt();
        int[] dp=new int[n+1];
        int[] arr=new int[n+1];

        for(int i=1;i<=n;i++){
            arr[i]=sc.nextInt();
        }

        int maxSum=arr[1];
        dp[1]=arr[1];

        for(int i=2;i<=n;i++){

            dp[i]=Math.max(arr[i],dp[i-1]+arr[i]);
            maxSum=Math.max(maxSum,dp[i]); //최대합 갱신
        }

        System.out.println(maxSum);
    }
}