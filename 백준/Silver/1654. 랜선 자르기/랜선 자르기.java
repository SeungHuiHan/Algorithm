import java.util.*;

public class Main{
    static int K,N;
    static int[] rans;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        K=sc.nextInt();
        N=sc.nextInt();

        rans=new int[K];
        int maxLength=Integer.MAX_VALUE;
        for(int i=0;i<K;i++){
            rans[i]=sc.nextInt();
            maxLength=Math.max(maxLength,rans[i]); //최소값 구하기
        }


        long left=0;
        long right=maxLength;
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

    static boolean canCut(long can){
        int count=0;

        for(int ran:rans){
            count+=ran/can;
        }

        if(count>=N) return true;
        else return false;
    }
}