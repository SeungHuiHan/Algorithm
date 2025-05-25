import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(bf.readLine());

        int[] arr=new int[T];
        int max=0;


        for(int i=0;i<T;i++){

            arr[i]=Integer.parseInt(bf.readLine());
            max=Math.max(max,arr[i]);
        }

        long[][] dp=new long[max+1][10];


        for(int i=0;i<=9;i++){
            dp[1][i]=1;
        }

        for(int i=2;i<=max;i++){
            for(int j=0;j<=9;j++){ //뒷자리
                for(int k=0;k<=j;k++){ //앞자리
                    dp[i][j]+=dp[i-1][k];
                }
            }
        }

        StringBuilder sb=new StringBuilder();
        for(int a:arr){
            
                long sum=0;
                for(int i=0;i<=9;i++){
                    sum+=dp[a][i];
                }

                sb.append(sum).append("\n");
            
        }

        System.out.println(sb);
    }
}