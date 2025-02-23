import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int N=sc.nextInt();
        
        int[] arr=new int[N+1];
        int[] dp=new int[N+1];
        
        
        int max=0;
        for(int i=1;i<=N;i++){
            arr[i]=sc.nextInt();
            dp[i]=arr[i]; //자기 자신 초기화
        }
        
        for(int i=1;i<=N;i++){
            
            for(int j=1;j<i;j++){
                if(arr[j]<arr[i]){
                    dp[i]=Math.max(dp[i],dp[j]+arr[i]);
                }
            }
        }
        
        int result=0;
        for(int i=1;i<=N;i++){
            result=Math.max(result,dp[i]);
        }
        
        System.out.println(result);
    }
}