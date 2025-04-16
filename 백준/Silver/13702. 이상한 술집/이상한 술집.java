import java.util.*;

public class Main{
    static int N,K;
    static long[] bottles;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        K=sc.nextInt();
        bottles=new long[N];

        long max=0;
        for(int i=0;i<N;i++){
            bottles[i]=sc.nextLong();
            max=Math.max(max,bottles[i]);
        }


        long left=1;
        long right=max;
        long answer=0;

        while(left<=right){
            long mid=(left+right)/2;

            if(canCut(mid)){
                answer=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }

        System.out.println(answer);

    }

    private static boolean canCut(long mid){
        int count=0;

        for(long bottle:bottles){
            count+=bottle/mid;
        }

        return count>=K;
    }
}