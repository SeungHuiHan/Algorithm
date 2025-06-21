import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N=Integer.parseInt(bf.readLine());

        int[][] arr=new int[N][3];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());

            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int person=Integer.parseInt(st.nextToken());
            arr[i][0]=start;
            arr[i][1]=end;
            arr[i][2]=person;

        }

        Arrays.sort(arr, Comparator.comparingInt(a->a[1]));


        long[] dp=new long[N];
        dp[0]=arr[0][2];


        for (int i = 1; i < N; i++) {
            long include = arr[i][2];

            for (int j = i - 1; j >= 0; j--) {
                if (arr[j][1] <= arr[i][0]) {
                    include += dp[j];
                    break;
                }
            }

            dp[i] = Math.max(dp[i - 1], include);
        }

        System.out.println(dp[N-1]);
    }
}