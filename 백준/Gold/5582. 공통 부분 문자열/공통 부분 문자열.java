import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        String input1=bf.readLine();
        String input2=bf.readLine();

        int len1=input1.length();
        int len2=input2.length();
     
        int[][] dp=new int[len1+1][len2+1];

        int maxLength=0;
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(input1.charAt(i-1)==input2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    maxLength=Math.max(maxLength,dp[i][j]);
                }
            }
        }
        System.out.println(maxLength);

    }
}