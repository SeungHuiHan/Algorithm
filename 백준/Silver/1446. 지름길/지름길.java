import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int D=sc.nextInt();

        int[] dp=new int[D+1];
        for(int i=1;i<=D;i++){
            dp[i]=i;
        }
        
        ArrayList<int[]> list=new ArrayList<>();
        for(int i=1;i<=N;i++){
            int start=sc.nextInt(); //지름길 시작점
            int end=sc.nextInt(); //지름길 도착점
            int len=sc.nextInt(); //지름길 길이
            if(end<=D)
                list.add(new int[]{start,end,len});
        }
        
        for(int i=1;i<=D;i++){
            dp[i]=Math.min(dp[i],dp[i-1]+1);
            
            for(int j=0;j<list.size();j++){
                int start=list.get(j)[0];
                int end=list.get(j)[1];
                int len=list.get(j)[2];
                
                dp[end]=Math.min(dp[end],dp[start]+len);
                
            }
            
        }
        System.out.println(dp[D]);
        
    }
}