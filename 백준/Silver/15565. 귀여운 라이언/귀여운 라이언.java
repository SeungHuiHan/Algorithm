import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int K=sc.nextInt();

        int[] dp=new int[N];
        int minLine=Integer.MAX_VALUE;

        for(int i=0;i<N;i++){
            dp[i]=sc.nextInt();
        }

        int start=0;
        int count=0;
        for(int end=0;end<N;end++){
            if(dp[end]==1)
                count++;

            while(count>=K){
                if (count == K) {
                    minLine = Math.min(minLine, end - start + 1);
                }

                if (dp[start] == 1) count--;
                start++;
            }

        }

        if(minLine==Integer.MAX_VALUE)
            System.out.println(-1);
        else System.out.println(minLine);
    }
}