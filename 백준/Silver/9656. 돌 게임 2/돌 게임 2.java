import java.util.*;
//i개가 남았을때
//i-1을 가져가 상대방을 지게 한다.
//i-3을 가져가 상대방을 지게 한다.
//i-1과 i-3를 다 이겼을때 상대방은 백퍼 짐
//i-1과 i-3 중 하나라도 지면 상대방은 이김
//i-1과 i-3를 다 졌을때 상대방은 백퍼 이김
public class Main{
    public static void main(String[] args){
       Scanner sc=new Scanner(System.in);
        
        int N=sc.nextInt();
        boolean[] dp=new boolean[N+1];
        
        dp[1]=true; //상근이가 한개 가져가서 이김
        if(N>=2) dp[2]=false; //찬영이가 이김
        if(N>=3) dp[3]=true; //상근이가 3개 가져가서 이김
        
        if(N>=4){
            for(int i=4;i<=N;i++){
               dp[i]=!(dp[i-1] && dp[i-3]);
           }
        }
       
        System.out.println(dp[N]?"CY":"SK"); //마지막이 true면 찬영이가 이김
    }
}