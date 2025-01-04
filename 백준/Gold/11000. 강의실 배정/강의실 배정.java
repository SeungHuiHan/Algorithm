import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N=Integer.parseInt(bf.readLine());
        int[][] classes=new int[N][2];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            classes[i][0]=Integer.parseInt(st.nextToken());
            classes[i][1]=Integer.parseInt(st.nextToken());
        }

        //종료시간을 오름차순으로, 종료시간이 같다면 시작시간 순으로 오름차
       // Arrays.sort(classes,(a,b)->{
      //      if(a[1]!=b[1]) return Integer.compare(a[1],b[1]);
         //   return Integer.compare(a[0],b[0]);
       // });
        
        Arrays.sort(classes, Comparator.comparingInt(a->a[0]));

        PriorityQueue<Integer> answer=new PriorityQueue<>();

        for(int i=0;i<N;i++){
            int startTime=classes[i][0];
            int endTime=classes[i][1];

            if(!answer.isEmpty() && answer.peek()<=startTime){
                answer.poll();
            }
            answer.add(endTime);
        }


        System.out.println(answer.size());
    }
}