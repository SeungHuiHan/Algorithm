import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();

        int[] dp=new int[N+1];
        int[] arr=new int[N+1];
        String[] str=new String[N+1];

        for(int i=1;i<=N;i++){
            arr[i]=sc.nextInt();
            dp[i]=1; //초기값 1로 설정
            str[i]=arr[i]+" ";
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<i;j++){
                if(arr[i]>arr[j] ){
                    if(dp[i]<dp[j]+1){
                        dp[i]=dp[j]+1;
                        str[i]=str[j]+arr[i]+" ";
                    }


                }
            }
        }

        int max=0;
        int maxIndex=0;
        for(int i=1;i<=N;i++){
            if(dp[i]>max){
                max=dp[i];
                maxIndex=i;
            }
        }

        System.out.println(max);
        System.out.println(str[maxIndex]);
    }
}