import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N=Integer.parseInt(bf.readLine());
        int[][] arr=new int[N][2];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
        }

        //종료시간을 오름차순, 종료시간이 같으면 시작시간으로 정렬
        Arrays.sort(arr,(a,b)->{
            if(a[1]!=b[1]) return Integer.compare(a[1],b[1]);
            return Integer.compare(a[0],b[0]);
        });

        int count=0;
        int endTime=0;

        for(int i=0;i<N;i++){
            if(arr[i][0]>=endTime) {
                count++;
                endTime=arr[i][1];
            }
        }

        System.out.println(count);

    }
}