import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N=Integer.parseInt(bf.readLine());
        int[][] assignment=new int[N][2];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            assignment[i][0]=Integer.parseInt(st.nextToken());
            assignment[i][1]=Integer.parseInt(st.nextToken());
        }

        //마감일 내림차순,마감일이 같으면 점수 내림차순
        Arrays.sort(assignment,(a,b)-> {
            if(a[0]==b[0]) return Integer.compare(b[1],a[1]);
           return Integer.compare(b[0], a[0]);
        });

        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int totalSum=0;
        int MaxDeadline=assignment[0][0]; //가장 긴 마감일  

        int index=0;
        for(int i=MaxDeadline;i>0;i--){

            while(index<N && assignment[index][0]>=i){
                pq.add(assignment[index][1]);
                index++;
            }

            if(!pq.isEmpty()) totalSum+=pq.poll();
        }

        System.out.println(totalSum);
    }
}