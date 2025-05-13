import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int[][] miro=new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=1;j<=m;j++){
                miro[i][j]=Integer.parseInt(st.nextToken());
            }
           
        }


        long[][] dp=new long[n+1][m+1];

        //dp[1][1]=miro[1][1];

       
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+miro[i][j];               
            }
        }

        System.out.println(dp[n][m]);
    }
}