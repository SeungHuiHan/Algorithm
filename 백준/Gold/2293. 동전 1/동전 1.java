import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
       BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());

        int[] dp=new int[k+1];
        int[] coin=new int[n];

        for(int i=0;i<n;i++){
            coin[i]=Integer.parseInt(bf.readLine());
        }

        //가치의 합이 0인 경우는 아무 동전도 사용하지 않은 방법 - 1가지
        dp[0]=1;

        for(int i=0;i<n;i++){
            for(int j=coin[i];j<=k;j++){
                dp[j]+=dp[j-coin[i]];
            }
        }

        System.out.println(dp[k]);

        }
    }
    
