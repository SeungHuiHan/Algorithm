import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T;
        ArrayList<Long> list=new ArrayList<>();


        while((T=Integer.parseInt(bf.readLine()))!=0){
            int[][] arr=new int[T+1][3+1];

            for(int i=1;i<=T;i++){
                st=new StringTokenizer(bf.readLine());
                arr[i][1]=Integer.parseInt(st.nextToken());
                arr[i][2]=Integer.parseInt(st.nextToken());
                arr[i][3]=Integer.parseInt(st.nextToken());
            }

            long[][] dp=new long[T+1][3+1];
            dp[1][1] = Long.MAX_VALUE;
            dp[1][2] = arr[1][2];
            dp[1][3] = dp[1][2]+arr[1][3];

            for(int i=2;i<=T;i++){
                dp[i][1]=Math.min(dp[i-1][1],dp[i-1][2])+arr[i][1];
                dp[i][2]=Math.min(dp[i][1],Math.min(dp[i-1][1],Math.min(dp[i-1][2],dp[i-1][3])))+arr[i][2];
                dp[i][3]=Math.min(dp[i][2],Math.min(dp[i-1][2],dp[i-1][3]))+arr[i][3];
            }

            list.add(dp[T][2]);
        }



        for(int i=0;i<list.size();i++){
            System.out.println((i+1) + ". " + list.get(i));
        }


    }
}