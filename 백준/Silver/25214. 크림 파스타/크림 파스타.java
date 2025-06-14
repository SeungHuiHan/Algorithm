import java.util.*;


public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();

        int[] arr=new int[N];

        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }


        int[] dp=new int[N];


        int min=arr[0];
        for(int i=1;i<N;i++){

            dp[i]=Math.max(dp[i-1],arr[i]-min);
            min=Math.min(min,arr[i]);
        }

        StringBuilder sb=new StringBuilder();
        for(int d:dp){
            sb.append(d+" ");
        }

        System.out.println(sb);
    }
}