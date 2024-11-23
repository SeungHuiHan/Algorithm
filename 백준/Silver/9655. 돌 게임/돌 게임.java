import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int N=sc.nextInt();
        boolean[] dp=new boolean[N+1];
        
        dp[1]=true; //상근 이김
        if(N>=2) dp[2]=false; //찬영 이김
        if(N>=3) dp[3]=true; //상근 이김
        
        //상대가 dp[i-1],dp[i-3] 둘다 이겨야지 현재 사람이 진다.
        //상대가 dp[i-1],dp[i-3] 하나라도 진다면 현재 사람이 반드시 이긴다.
        for(int i=4;i<=N;i++){
            dp[i]=!dp[i-1]|| !dp[i-3];
        }
        
        System.out.println(dp[N]?"SK":"CY");
    }
}