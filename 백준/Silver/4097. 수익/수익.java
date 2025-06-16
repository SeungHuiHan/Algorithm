import java.util.*;
import java.io.*;


public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        int N;

        while((N=Integer.parseInt(bf.readLine()))!=0){
            int[] arr=new int[N+1];
            for(int i=1;i<=N;i++){
                arr[i]=Integer.parseInt(bf.readLine());
            }

            long max=arr[1];
            long sum=arr[1];
            for(int i=2;i<=N;i++){
                //합이 음수일때, -를 더해도 양수일때
                sum = Math.max(arr[i], sum + arr[i]);
                max = Math.max(max, sum);
            }

            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }
}