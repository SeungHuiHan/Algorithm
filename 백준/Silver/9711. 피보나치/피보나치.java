import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T=Integer.parseInt(bf.readLine());


        ArrayList<int[] > list=new ArrayList<>();
        int maxP=0;
        for(int i=0;i<T;i++){
            st=new StringTokenizer(bf.readLine());
            int P=Integer.parseInt(st.nextToken());
            int Q=Integer.parseInt(st.nextToken());
            list.add(new int[]{P,Q});
            maxP=Math.max(maxP,P);
        }

        BigInteger[] dp=new BigInteger[maxP+1];
        dp[0]=BigInteger.ZERO;
        dp[1]=BigInteger.ONE;
        for(int i=2;i<=maxP;i++){
            dp[i]=dp[i-1].add(dp[i-2]);
        }



        StringBuilder sb=new StringBuilder();

        for(int i=0;i<T;i++){
            int[] a=list.get(i);
            BigInteger M=dp[a[0]].mod(BigInteger.valueOf(a[1]));

            sb.append("Case #"+(i+1)+": "+ M).append("\n");

        }

        System.out.println(sb);
    }
}