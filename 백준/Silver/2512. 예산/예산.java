import java.util.*;

public class Main{
    static int N;
    static long M;
    static int[] costs;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        costs=new int[N];
        int maxCost=0;
        for(int i=0;i<N;i++){
            costs[i]=sc.nextInt();
            maxCost=Math.max(maxCost,costs[i]);
        }

        M=sc.nextInt();

        long left=0;
        long right=maxCost;
        long answer=0;


        while(left<=right){
            long mid=(left+right)/2;

            if(canLimit(mid)){
                answer=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }

        System.out.println(answer);

    }

    static boolean canLimit(long limit){
        int sum=0;

        for(int cost:costs){
            if(cost>=limit){
                sum+=limit;
            }else{
                sum+=cost;
            }
        }

        return sum<=M;
    }
}