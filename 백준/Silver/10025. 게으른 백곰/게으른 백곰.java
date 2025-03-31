import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int K=sc.nextInt();
        int[] arr=new int[1000001];
        int xmax=0;
        for(int i=0;i<N;i++){
            int g=sc.nextInt();
            int x=sc.nextInt();
            arr[x]=g;
            xmax=Math.max(xmax,x);
        }


        int total=0;
        int start=0;
        int maxs=Integer.MIN_VALUE;

        for(int end=0;end<=xmax;end++){

            total+=arr[end];


            while(end-start>2*K){
                total-=arr[start];
                start++;
            }

            maxs=Math.max(maxs,total);


        }

        System.out.println(maxs);
    }
}