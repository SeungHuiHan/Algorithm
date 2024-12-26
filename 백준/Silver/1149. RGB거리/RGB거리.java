import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N=Integer.parseInt(br.readLine());
        int[][] dp=new int[N+1][4];
        int[][] RGB=new int[N+1][4];

        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<=3;j++){
                RGB[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        //초기화
        dp[1][1]=RGB[1][1];
        dp[1][2]=RGB[1][2];
        dp[1][3]=RGB[1][3];


        for(int i=2;i<=N;i++){
            dp[i][1]=RGB[i][1]+Math.min(dp[i-1][2],dp[i-1][3]); //현재 빨강으로 선책
            dp[i][2]=RGB[i][2]+Math.min(dp[i-1][1],dp[i-1][3]); //현재 초록으로 선책
            dp[i][3]=RGB[i][3]+Math.min(dp[i-1][1],dp[i-1][2]); //현재 파랑으로 선책

        }

        System.out.println(Math.min(dp[N][1],Math.min(dp[N][2],dp[N][3])));
    }
}