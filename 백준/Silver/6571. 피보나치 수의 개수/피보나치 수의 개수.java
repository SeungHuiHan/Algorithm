import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ArrayList<BigInteger[]> list=new ArrayList<>();
        BigInteger max=BigInteger.ZERO;
        while(true){
            String line = bf.readLine();
            if (line == null || line.isEmpty()) break;

            st=new StringTokenizer(line);
            BigInteger a=new BigInteger(st.nextToken());
            BigInteger b=new BigInteger(st.nextToken());

            if (a.equals(BigInteger.ZERO) && b.equals(BigInteger.ZERO)) break;

            list.add(new BigInteger[]{a,b});
            if(b.compareTo(max)>0) max=b;//최대값
        }
        ArrayList<BigInteger> dp = new ArrayList<>();
        dp.add(BigInteger.ONE);                   // F1 = 1
        dp.add(BigInteger.TWO);
        while (true) {
            BigInteger next = dp.get(dp.size() - 1).add(dp.get(dp.size() - 2));
            if (next.compareTo(max) > 0) break;
            dp.add(next);
        }

        StringBuilder sb = new StringBuilder();
        for (BigInteger[] range : list) {
            BigInteger a = range[0];
            BigInteger b = range[1];

            int count = 0;
            for (BigInteger fib : dp) {
                if (fib.compareTo(a) >= 0 && fib.compareTo(b) <= 0) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }

        System.out.print(sb);
        
    }
}