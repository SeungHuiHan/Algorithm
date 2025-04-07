import java.util.*;

public class Main{
    static int N,M;
    static int[] costs;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        M=sc.nextInt();


        costs=new int[N];
        int max=Integer.MIN_VALUE;
        long sum=0;
        for(int i=0;i<N;i++){
            costs[i]=sc.nextInt();
            max=Math.max(max,costs[i]);
            sum+=costs[i];
        }


        long left=max;
        long right=sum;
        long answer=sum;

        while(left<=right){
            long mid=(left+right)/2;

            if(canPass(mid)){
                answer=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }

        System.out.println(answer);
    }

    public static boolean canPass(long mid){
        int count=1;
        long midCopy=mid;

        for(int cost:costs){

            if(midCopy<cost){
                count++;
                midCopy=mid;
            }

            midCopy-=cost;

        }
        return count<=M;
    }
}