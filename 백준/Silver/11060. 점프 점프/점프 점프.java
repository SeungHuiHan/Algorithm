import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));



        int N=Integer.parseInt(bf.readLine());
        int[] arr=new int[N+1];

        StringTokenizer st=new StringTokenizer(bf.readLine());
        for(int i=1;i<=N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int[] dp=new int[N+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[1]=0;

        for(int i=1;i<N;i++){
            int target=arr[i];
            if(dp[i]==Integer.MAX_VALUE) continue;
            for(int j=i+1;j<=i+target && j<=N;j++){

                dp[j]=Math.min(dp[j],dp[i]+1);
            }

        }

//        if(dp[N]==0)
        System.out.println(dp[N] == Integer.MAX_VALUE ? -1 : dp[N]);
    }
}