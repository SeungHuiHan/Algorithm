import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        long[][][]dp=new  long[21][21][21];

        //if a < b and b < c, then w(a, b, c) returns:
        //w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)

        //otherwise it returns:
        //w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)

        for(int a=0;a<=20;a++){
            for(int b=0;b<=20;b++){
                for(int c=0;c<=20;c++){
                    if(a<=0 || b<=0 || c<=0){
                        dp[a][b][c]=1;
                    }else if(a<b && b<c){
                        dp[a][b][c]=dp[a][b][c-1]+dp[a][b-1][c-1]-dp[a][b-1][c];
                    }else{
                        dp[a][b][c]=dp[a-1][b][c]+dp[a-1][b-1][c]+dp[a-1][b][c-1]-dp[a-1][b-1][c-1];
                    }
                }
            }
        }

        while(true){
            st=new StringTokenizer(bf.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());

            if(a==-1 && b==-1 && c==-1){
                break;
            }
            //w(1, 1, 1) =
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ");
            if(a<=0 || b<=0 || c<=0)
                sb.append(1).append("\n");
            else if (a>20 || b>20 || c>20)
                sb.append(dp[20][20][20]).append("\n");
                
            else
                sb.append(dp[a][b][c]).append("\n");
        }


        System.out.print(sb);


    }
}