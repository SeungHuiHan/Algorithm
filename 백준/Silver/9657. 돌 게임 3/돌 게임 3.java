import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        boolean[] dp=new boolean[n+1];


        //이길 수 있냐, 없냐
        //i-1,i-3,i-4 수에서 전부 져야 창영이가 이기는거
        dp[1]=true;
        if(n==1){System.out.println(dp[n]?"SK":"CY"); return;}
        if(n==2){System.out.println(dp[n]?"SK":"CY"); return;}
        dp[3]=true;
        if(n==3){System.out.println(dp[n]?"SK":"CY"); return;}
        dp[4]=true;
        if(n==4){System.out.println(dp[n]?"SK":"CY"); return;}

        for(int i=5;i<=n;i++){
            dp[i]=!(dp[i-1]&&dp[i-3]&&dp[i-4]); //반대편
        }

        System.out.println(dp[n]?"SK":"CY");
    }
}