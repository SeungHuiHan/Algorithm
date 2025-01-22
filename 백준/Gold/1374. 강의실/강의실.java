import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int N=Integer.parseInt(br.readLine());
        int[][] arr=new int[N][2];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            int number=Integer.parseInt(st.nextToken());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());

            arr[i][0]=start;
            arr[i][1]=end;
        }
        //시작시간 오름차순, 시작시간이 같으면 종료시간 순 내림차순
        Arrays.sort(arr,(a, b)->{
            if(a[0]==b[0]) return Integer.compare(a[1],b[1]);
            return Integer.compare(a[0],b[0]);
        });

        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int i=0;i<N;i++){
            int start=arr[i][0];
            int end=arr[i][1];

            if(!pq.isEmpty() && pq.peek()<=start){
                pq.poll();
            }

            pq.add(end);
        }


        System.out.println(pq.size());


    }
}