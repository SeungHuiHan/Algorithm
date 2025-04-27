import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(bf.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());


        st=new StringTokenizer(bf.readLine());
        int[] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<M;i++){

            st=new StringTokenizer(bf.readLine());

            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());


            // start 이상인 첫 번째 위치
            int lower = 0;
            int upper = N;
            while(lower < upper){
                int mid = (lower + upper) / 2;
                if(arr[mid] >= start){
                    upper = mid;
                } else {
                    lower = mid + 1;
                }
            }
            int startIndex = lower;


            // end 초과하는 첫 번째 위치
            lower = 0;
            upper = N;
            while(lower < upper){
                int mid = (lower + upper) / 2;
                if(arr[mid] > end){
                    upper = mid;
                } else {
                    lower = mid + 1;
                }
            }
            int endIndex = lower;


            sb.append(endIndex-startIndex).append("\n");


        }




        System.out.println(sb);

    }
}