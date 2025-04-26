import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        int M=Integer.parseInt(st.nextToken()); //사대의 수
        int N=Integer.parseInt(st.nextToken()); //동물의 수
        int L=Integer.parseInt(st.nextToken()); //거리

        st=new StringTokenizer(bf.readLine());
        int[] marr=new int[M];
        for(int i=0;i<M;i++){
            marr[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(marr);

        int[][] narr=new int[N][2];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            narr[i][0]=Integer.parseInt(st.nextToken());
            narr[i][1]=Integer.parseInt(st.nextToken());
        }


        int answer=0;

        for(int i=0;i<N;i++){
            int x=narr[i][0];
            int y=narr[i][1];

            if(y>L) continue; //사정거리보다 y가 더 작을때


            int left=0;
            int right=M-1;
            boolean flag=false;
            while(left<=right){
                int mid=(left+right)/2;

                if(Math.abs(marr[mid]-x)+y<=L){
                    flag=true;
                    break;

                }

                if(marr[mid]-x>0){ //mid의 위치가 동물의 x보다 오른쪽일때
                    right=mid-1;
                    
                }else{ //왼쪽일때
                    left=mid+1;
                }
            }

            if(flag) answer++;
        }


        System.out.println(answer);

    }
}