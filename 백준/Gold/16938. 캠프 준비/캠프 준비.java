import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int L=sc.nextInt();
        int R=sc.nextInt();
        int X=sc.nextInt();

        int[] problem=new int[N];

        for(int i=0;i<N;i++){
            problem[i]=sc.nextInt();
        }

        

        int count=0;
        for(int mask=1;mask<(1<<N);mask++){
            int sum=0;
            int minDifficulty=Integer.MAX_VALUE;
            int maxDifficulty=Integer.MIN_VALUE;
            int problemCount=0;

            for(int i=0;i<N;i++){
                if((mask & (1<<i))!=0){
                    minDifficulty=Math.min(minDifficulty,problem[i]);
                    maxDifficulty=Math.max(maxDifficulty,problem[i]);
                    sum+=problem[i];
                    problemCount++;
                }
            }

            if(problemCount>=2 && sum>=L && sum<=R && (maxDifficulty-minDifficulty)>=X) count++;
        }

        System.out.println(count);
    }
}