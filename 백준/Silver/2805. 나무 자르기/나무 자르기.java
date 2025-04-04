import java.util.*;

public class Main{
    static int N,M=0;
    static int[] trees;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        M=sc.nextInt();
        trees=new int[N];
        int maxLength=0;

        for(int i=0;i<N;i++){
            trees[i]=sc.nextInt();
            maxLength=Math.max(maxLength,trees[i]); //제일 긴 나무 길이
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

    static boolean canCut(long height){
        long sum=0;

        for(int tree:trees){
            if(tree>=height)
                sum+=(tree-height);
        }

        return sum>=M;
    }
}