import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        //N, K, B
        int N=sc.nextInt();
        int K=sc.nextInt();
        int B=sc.nextInt();

        int[] arr=new int[N];
        for(int i=0;i<B;i++){
            int n=sc.nextInt();
            arr[n-1]=1;
        }

        int start=0;
        int count=0;
        int minC=Integer.MAX_VALUE;
        for(int end=0;end<N;end++){
            if(arr[end]==1) count++;

            while(end-start+1>K){
                if(arr[start]==1) count--;
                start++;
            }
            if(end-start+1==K)
                minC=Math.min(minC,count);
        }

        System.out.println(minC);
    }
}