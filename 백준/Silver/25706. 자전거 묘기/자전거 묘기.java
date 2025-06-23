import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
       
        int N=Integer.parseInt(bf.readLine());

        int[] arr=new int[N+2];
        
        StringTokenizer st=new StringTokenizer(bf.readLine());
        for(int i=1;i<=N;i++){
            int a=Integer.parseInt(st.nextToken());
            arr[i]=a;
        }
    
        
        int[] dp=new int[N+2];
        
        // 뒤에서부터 dp 계산
        for (int i = N; i >= 1; i--) {
            int next=0;
            if(arr[i]==0){
                next=i+1;
            }else{
                next=i+arr[i]+1;
            }
         
            if (next > N) {
                dp[i] = 1;
            } else {
                dp[i] = 1 + dp[next];
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(dp[i]).append(" ");
        }
        System.out.println(sb);
    }
}