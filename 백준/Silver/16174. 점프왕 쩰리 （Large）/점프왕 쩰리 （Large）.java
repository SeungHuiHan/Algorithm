import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N=Integer.parseInt(bf.readLine());
        int[][] arr=new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            st=new StringTokenizer(bf.readLine());
            for(int j=1;j<=N;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] dp=new boolean[N+1][N+1];
        dp[1][1]=true;

        for(int i=1;i<=N;i++){

            for(int j=1;j<=N;j++){
                if(!dp[i][j]) continue;
                if(arr[i][j]+i<=N){
                    dp[i+arr[i][j]][j]=true;
                }
                if(arr[i][j]+j<=N){
                    dp[i][j+arr[i][j]]=true;
                }
            }
        }

        System.out.println(dp[N][N]?"HaruHaru":"Hing");
    }
}