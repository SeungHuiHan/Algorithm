import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N=Integer.parseInt(bf.readLine());
        int[][] wires=new int[N][2];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(bf.readLine());
            wires[i][0]=Integer.parseInt(st.nextToken()); //A전깃줄
            wires[i][1]=Integer.parseInt(st.nextToken()); //B전깃줄
        }

        Arrays.sort(wires, Comparator.comparingInt(a->a[0])); //A전깃줄 오름차순 정렬

        int[] barr=new int[N];
        for(int i=0;i<N;i++){
            barr[i]=wires[i][1];
        }

        ArrayList<Integer> list=new ArrayList<>();
        int[] prev=new int[N]; //연결 추적
        Arrays.fill(prev,-1);

        boolean[] isLis=new boolean[N]; //a 전봇대에서 가장 긴 수열 확인
        int[] posToIndex=new int[N]; //list.get(i)위치에 실제 인덱스 들어갔는지


        for(int i=0;i<N;i++){
            int b=wires[i][1];
            int pos= Collections.binarySearch(list,b);
            if(pos<0) pos=-(pos+1);

            if(pos==list.size()){
                list.add(b);
            }else{
                list.set(pos,b);
            }

            posToIndex[pos]=i; //list.get(pos)는 실제 wires의 i번째 값

            if(pos>0) prev[i]=posToIndex[pos-1]; //추적

        }

        int lisLen=list.size();
        int cur=posToIndex[lisLen-1];

        while(cur!=-1){
            isLis[cur]=true;
            cur=prev[cur];
        }


        StringBuilder sb=new StringBuilder();
        sb.append(N-list.size()).append("\n");

        ArrayList<Integer> result=new ArrayList<>();
        for(int i=0;i<N;i++){
            if(!isLis[i]){
                result.add(wires[i][0]);
            }
        }

        Collections.sort(result);
        for(int i=0;i<result.size();i++){
            sb.append(result.get(i)).append("\n");
        }


        System.out.println(sb);
    }
}
