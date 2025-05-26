import java.util.*;
import java.io.*;
import java.math.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list=new ArrayList<>();
        String line;
        int max=0;
        while ((line = bf.readLine()) != null && !line.isEmpty()) {
            list.add(Integer.parseInt(line));
            max=Math.max(max,Integer.parseInt(line));
        }

        BigInteger[] dp=new BigInteger[max+1];
        dp[0]=BigInteger.ONE;
        if(max>=1)dp[1]=BigInteger.ONE;
        if(max>=2) dp[2]=BigInteger.valueOf(3);

        for(int i=3;i<=max;i++){
            dp[i]=dp[i-1].add(BigInteger.TWO.multiply(dp[i-2]));
        }

        StringBuilder sb=new StringBuilder();
        for(int a:list){
            sb.append(dp[a]).append("\n");
        }

        System.out.println(sb);
        
    }
}