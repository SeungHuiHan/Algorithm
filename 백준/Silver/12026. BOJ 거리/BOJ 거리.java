import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);


        int n=sc.nextInt();
        sc.nextLine();

        long[] dp=new long[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        String s=sc.nextLine();

        for(int i=0;i<n-1;i++){
            if(dp[i]==Integer.MAX_VALUE)continue;

            char current=s.charAt(i);
            char next=nextChar(current);

            for(int j=i+1;j<n;j++){
                if(s.charAt(j)==next){
                    dp[j]=Math.min(dp[j],dp[i]+(j-i)*(j-i));

                }
            }
        }


        System.out.println(dp[n-1]==Integer.MAX_VALUE?-1:dp[n-1]);

    }

    private static char nextChar(char c){
        if(c=='B') return  'O';
        if(c=='O') return  'J';
        if(c=='J') return  'B';
        return c;
    }
}