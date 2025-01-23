import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt(); //물품 수
        int K=sc.nextInt(); //버틸 수 있는 최대 무게
        int[] dp=new int[K+1];

        for(int i=1;i<=N;i++){
            int W=sc.nextInt(); // 무게
            int V=sc.nextInt(); //가치

            // 현재 물건을 넣는 경우를 역순으로 업데이트
            for (int j = K; j >= W; j--) {
                dp[j] = Math.max(dp[j], dp[j - W] + V);
            }
        }



        System.out.println(dp[K]);
    }
}