import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list=new ArrayList<>();

        String input;
        int max=0;
        while(true){
            input = bf.readLine();
            if(input.equals("0")) break;

            int n=Integer.parseInt(input);

            list.add(n);
            max=Math.max(max,n);
        }

        boolean[] isPrime=new boolean[2*max+1];
        Arrays.fill(isPrime,true);
        isPrime[0]=isPrime[1]=false;

        for(int i=2;i*i<=2*max;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=2*max;j+=i){
                    isPrime[j]=false;
                }
            }
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<list.size();i++){
            int count=0;
            int n=list.get(i);
            for(int j=n+1;j<=2*n;j++){
                if(isPrime[j]) count++;
            }


            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}