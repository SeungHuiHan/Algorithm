import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        String s1=sc.nextLine();
        String s2=sc.nextLine();

        int N=Math.max(s1.length(),s2.length());
        int[][] dp=new int[s1.length()+1][s2.length()+1];

        //Arrays.fill(dp,1);

        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[s1.length()][s2.length()]);

        
    }
}