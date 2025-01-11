import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        if(N==1){
            System.out.println(1);
            return ;
        }
       // long[] dp=new long[N+1];
   
        long prev1=1; //dp[0]=0;
        long prev2=2; //dp[1]=1;
        for(int i=3;i<=N;i++){
            long current=(prev1+prev2)%15746; //dp[i]=(dp[i-2]+dp[i-1])%15746;
            prev1=prev2;
            prev2=current;
        }
        
        System.out.println(prev2);
    }
}