import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list=new ArrayList<>();
        int N=0;
        String input;
        while ((input = bf.readLine()) != null) {
            if (input.equals("0")) break;

            int n = Integer.parseInt(input);
            list.add(n);
            N = Math.max(N, n);
        }

        boolean[] isPrime=new boolean[N+1];
        Arrays.fill(isPrime,true);
        isPrime[1]=false;

        for(int i=2;i*i<=N;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=N;j+=i){
                    isPrime[j]=false;
                }
            }
        }


        StringBuilder sb=new StringBuilder();
        for(int i=0;i<list.size();i++){
            int target=list.get(i);
            int left=0;
            int right=0;

            boolean flag=false;
            while(left<=target/2){
                right=target-left;

                if(isPrime[left] && isPrime[right]){
                    sb.append(target+" = "+left+" + "+right).append("\n");
                    flag=true;
                    break;
                }
                left++;

            }
            if(!flag)  sb.append("Goldbach's conjecture is wrong.").append("\n");

        }


        System.out.println(sb);
    }
}