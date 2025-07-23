import java.util.*;


public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);


        int N=sc.nextInt();
        int M=sc.nextInt();
        int[] arr=new int[N+1];
        int[] sum=new int[N+1];

        for(int i=1;i<=N;i++){
            arr[i]=sc.nextInt();
            sum[i]=sum[i-1]+arr[i]; //누적합
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<M;i++){
            
            int a=sc.nextInt();
            int b=sc.nextInt();
            sb.append(sum[b]-sum[a-1]).append("\n");
        }

        System.out.println(sb);
    }

}