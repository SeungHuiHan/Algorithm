import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        StringTokenizer st=new StringTokenizer(br.readLine());

        int[] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> list=new ArrayList<>();

        for(int i=0;i<N;i++){
            int a=arr[i];


            int index = Collections.binarySearch(list, a);  //이진탐색 index>0아면 리스트에 값있음 index<0이면 원소가 들어갈 -(위치+1)

            if(index<0){ //리스트에 값이 없을때
                index=-(index+1); //양수 index만들기
            }

            if(index==list.size()){
                list.add(a);
            }else{
                list.set(index,a); //덮어쓰기
            }
        }

        System.out.println(list.size());
    }
}