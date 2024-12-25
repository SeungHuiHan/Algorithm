import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] agrs)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(bf.readLine());
        int[] dp0=new int[41];
        int[] dp1=new int[41];

        dp0[0]=1;
        dp0[1]=0;
        dp0[2]=1;

        dp1[0]=0;
        dp1[1]=1;
        dp1[2]=1;


        for(int i=0;i<T;i++){
            int N=Integer.parseInt(bf.readLine());

            if(N>=2){
                for(int j=2;j<=N;j++){
                    dp0[j]=dp0[j-1]+dp0[j-2];
                    dp1[j]=dp1[j-1]+dp1[j-2];
                }
            }


            System.out.println(dp0[N]+" "+dp1[N]);
        }

    }
}