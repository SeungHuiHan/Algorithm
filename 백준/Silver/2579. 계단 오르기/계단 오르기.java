import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        //dp[i]=dp[i-1]+dp[i-3]
        int n=sc.nextInt();
        int[] dp=new int[n+1];
        
        int[] steps=new int[n+1];
        for(int i=1;i<=n;i++){
            steps[i]=sc.nextInt();
        }
        
        if(n==1) { 
            System.out.println(steps[1]);
            return;
        }
        if(n==2) {
            System.out.println(steps[1]+steps[2]);
            return;
        }
        
         dp[1]=steps[1];
         dp[2]=steps[1]+steps[2];
        
        for(int i=3;i<=n;i++){
          dp[i]=Math.max(dp[i-2]+steps[i],dp[i-3]+steps[i-1]+steps[i]);
        }
      
        
        System.out.println(dp[n]);
        
    }
}