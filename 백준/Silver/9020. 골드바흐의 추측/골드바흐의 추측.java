import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int T=sc.nextInt();

        int[] arr=new int[T];
        int N=0;
        for(int i=0;i<T;i++){
            arr[i]=sc.nextInt();
            N=Math.max(N,arr[i]);
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
        for(int i=0;i<T;i++){
            int target=arr[i]/2;
            int left=target;
            int right=target;

            while((left+right)!=target && !(isPrime[left] && isPrime[right])){
                left--;
                right++;
            }

            sb.append(left+" "+right).append("\n");
        }


        System.out.println(sb);
    }
}