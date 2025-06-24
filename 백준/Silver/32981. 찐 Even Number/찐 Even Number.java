import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(bf.readLine());

        int[] arr=new int[N];

        int max=0;

        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(bf.readLine());
            max=Math.max(max,arr[i]);
        }

        long[][] dp=new long[max+1][9];

        dp[1][2]=1;
        dp[1][4]=1;
        dp[1][6]=1;
        dp[1][8]=1;

        for(int i=2;i<=max;i++){
            for(int j=0;j<=8;j+=2){
                for(int k=0;k<=8;k+=2){
                    dp[i][j]=(dp[i][j]+dp[i-1][k])%1000000007;

                }
            }
        }




        StringBuilder sb=new StringBuilder();
        for(int a:arr){

            long sum=0;
            if(a==1){
                sb.append(5).append("\n");
            }else{
                for(long b:dp[a]){
                    sum=(sum+b)%1000000007;
                }
                sb.append(sum).append("\n");
            }



        }

        System.out.println(sb);
    }
}