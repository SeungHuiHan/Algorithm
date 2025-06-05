import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        
        int[] dp=new int[N+1];
        if(N==1){
            System.out.println(1);
            return;
        }
        dp[1]=1;

        if(N==2){
            System.out.println(2);
            return;
        }

        dp[2]=2;

        for(int i=3;i<=N;i++){
            dp[i]=(dp[i-1]+dp[i-2])%10; //바로 옆사람과 악수, 악수x
        }
        

        System.out.print(dp[N]);


    }
}