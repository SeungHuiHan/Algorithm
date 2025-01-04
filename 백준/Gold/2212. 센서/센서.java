import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(bf.readLine());
        int K=Integer.parseInt(bf.readLine());

        int[] arr=new int[N];
        StringTokenizer st=new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int[] difference=new int[N];
        for(int i=0;i<N-1;i++){
            difference[i]=arr[i+1]-arr[i];
        }

        Arrays.sort(difference);

        int sum=0;
        for(int i=0;i<N-(K-1);i++){
            sum+=difference[i];
        }

        System.out.println(sum);

    }
}