import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int T=sc.nextInt();
        int[] arr=new int[T];
        int max=0;
        for(int i=0;i<T;i++){
            arr[i]=sc.nextInt();
            max=Math.max(max,arr[i]);
        }

        long[] dp=new long[max+1];
        //1+1+1
        //2+1
        //1+2
        //3

        dp[0]=0;
        //dp[1]=1
        //dp[2]=2
        //dp[3]=4
        for(int i=1;i<=max;i++){
            if(i==1){
                dp[i]=dp[i-1]+1;
            }else if(i==2){
                dp[i]=dp[i-1]+dp[i-2]+1;
            }else if(i==3){
                dp[i]=dp[i-1]+dp[i-2]+dp[i-3]+1;
            }else{
                dp[i]=(dp[i-1]+dp[i-2]+dp[i-3])%1000000009;
            }
        }

        StringBuilder sb=new StringBuilder();
        for(int target:arr){
            sb.append(dp[target]).append("\n");
        }

        System.out.println(sb);

    }
}