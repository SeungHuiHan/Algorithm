import java.util.*;

public class Main{
    private static int N,M;
    private static long[] times;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        M=sc.nextInt();
        times=new long[N];

        long min=Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            times[i]=sc.nextInt();
            min=Math.min(min,times[i]);
        }

        long left=1;
        long right=min*M;
        long answer=0;

        while(left<=right){
            long mid=(left+right)/2;

            if(canDivision(mid)){
                answer=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }

        System.out.println(answer);

    }

    private static boolean canDivision(long mid){
        long count=0;

        for(long time:times){
            count+=mid/time;
        }

        return count>=M;
    }
}