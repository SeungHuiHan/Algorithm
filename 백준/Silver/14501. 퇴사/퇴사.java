import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int N=sc.nextInt();
        int[] dp=new int[N+2];
        int[] T=new int[N+1];
        int[] P=new int[N+1];
        
        dp[N+1]=0; //퇴사 후에는 수익이 없음
  
        for(int i=1;i<=N;i++){
            T[i]=sc.nextInt();
            P[i]=sc.nextInt();
        }
        
        //역순으로
        for(int i=N;i>=1;i--){
            if(i+T[i]-1<=N){
                dp[i]=Math.max(dp[i+1],P[i]+dp[i+T[i]]); //상담 안하는 경우와 상담이 끝난 다음날 최대 수익 
            }else{
                dp[i]=dp[i+1]; //상담 선택안함
            }
        }
        
        System.out.println(dp[1]);
        
        
    }
}