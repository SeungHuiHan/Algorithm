import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        int T=Integer.parseInt(bf.readLine());

        for(int i=0;i<T;i++){
            int N=Integer.parseInt(bf.readLine());

            int[] signals=new int[N];
            for(int j=0;j<N;j++){
                signals[j]=Integer.parseInt(bf.readLine());
            }

            ArrayList<Integer> list=new ArrayList<>();
            for(int j=0;j<N;j++){
                int signal=signals[j];
                int pos= Collections.binarySearch(list,signal);
                if(pos<0) pos=-(pos+1);

                if(pos==list.size()){
                    list.add(signal);
                }else{
                    list.set(pos,signal);
                }

            }

            sb.append(list.size()).append("\n");
        }

        System.out.println(sb);
    }
}