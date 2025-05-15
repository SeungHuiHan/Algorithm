import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        int T=Integer.parseInt(bf.readLine());

        for(int i=0;i<T;i++){
            st=new StringTokenizer(bf.readLine());

            int N=Integer.parseInt(st.nextToken());
            int M=Integer.parseInt(st.nextToken());

            st=new StringTokenizer(bf.readLine());
            List<Integer> pq=new ArrayList<>();
            Queue<int[]> q=new LinkedList<>();

            for(int j=0;j<N;j++){

                int n=Integer.parseInt(st.nextToken());
                pq.add(n); //중요도가 높은 순으로 집어 넣기
                q.add(new int[]{j,n}); //현재 인덱스, 값
            }

            Collections.sort(pq,Collections.reverseOrder()); //내림차순 정렬

            int order=0; //출력 순서
            while(!q.isEmpty()){
                int[] current=q.poll();

                if(current[1]==pq.get(0)){ //제일 높은 순서
                    order++; //찾는 순서 증가
                    pq.remove(0); //제일 높은 중요도 삭제
                    if(current[0]==M){ //알고 싶은것
                        sb.append(order).append("\n");
                        break;
                    }

                }else{
                    q.add(new int[]{current[0],current[1]}); //제일 높은 중요도에 해당안되면 다시 큐에 집어 널음
                }

            }


        }
        System.out.println(sb);

    }
}