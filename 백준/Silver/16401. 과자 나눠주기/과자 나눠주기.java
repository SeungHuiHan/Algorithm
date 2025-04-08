import java.util.*;

public class Main{
    static int M,N;
    static int[] sticks;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        M=sc.nextInt();
        N=sc.nextInt();

        sticks=new int[N];
        int max=0;
        for(int i=0;i<N;i++){
            sticks[i]=sc.nextInt();
            max=Math.max(max,sticks[i]);
        }

        int left=1;
        int right=max;
        int answer=0;
        while(left<=right){
            int mid=(left+right)/2;

            if(canCut(mid)){
                answer=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }

        System.out.println(answer);


    }

    static boolean canCut(int mid){
        int count=0;
        for(int stick:sticks){
            count+=stick/mid;
        }

        return count>=M;
    }
}