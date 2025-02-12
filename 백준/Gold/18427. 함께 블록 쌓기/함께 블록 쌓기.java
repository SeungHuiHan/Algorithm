import java.util.*;

public class Main{
    public static void main(String[ ]agrs){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int M=sc.nextInt();
        int H=sc.nextInt();
        sc.nextLine();

        int[][] dp=new int[N+1][H+1];
        int[][]student=new int[N][];


        for(int i=0;i<N;i++){
            String[] input=sc.nextLine().split(" ");
            student[i]=new int[input.length];
            for(int j=0;j<input.length;j++){
                student[i][j]=Integer.parseInt(input[j]);
            }
        }

        dp[0][0]=1; // 높이 0을 만드는 경우는 1개
        for(int i=1;i<=N;i++){
            for(int h=0;h<=H;h++){
                dp[i][h]=dp[i-1][h]; // 현재 학생이 블록을 사용하지 않는 경우

                for(int k=0;k<student[i-1].length;k++){
                    int block=student[i-1][k];

                    if(h>=block){
                        dp[i][h]=(dp[i][h]+dp[i-1][h-block])%10007;
                    }
                }
            }
        }

        System.out.println(dp[N][H]);
    }
}