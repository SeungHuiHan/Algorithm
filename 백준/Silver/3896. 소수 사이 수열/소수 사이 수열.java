import java.util.*;

public class Main{
   public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int T=sc.nextInt();

        int[] arr=new int[T];
        int max=0;
        for(int i=0;i<T;i++){
            arr[i]=sc.nextInt();
            max=Math.max(max,arr[i]);
        }

        boolean[] isPrime=new boolean[max+101];
        Arrays.fill(isPrime,true);//소수라고 가정
        isPrime[0]=isPrime[1]=false;

        for(int i=2;i*i<=isPrime.length-1;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=isPrime.length-1;j+=i){
                    isPrime[j]=false;
                }
            }
        }



        StringBuilder sb=new StringBuilder();
        for(int i=0;i<T;i++){
            int start=0;
            int end=0;
            int idx= arr[i];

            while(!isPrime[idx]){
                idx--;
            }

            start=idx;

            idx= arr[i];

            while(!isPrime[idx]){
                idx++;
            }

            end=idx;

            if(end==start){
                sb.append(0).append("\n");
            }else{
                sb.append(end-start).append("\n");
            }
        }
        System.out.println(sb);
    }
}