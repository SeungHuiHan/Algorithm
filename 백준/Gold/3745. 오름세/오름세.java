import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        StringBuilder sb=new StringBuilder();

        while(true){
            String t=bf.readLine();
            if (t == null || t.trim().isEmpty()) break;

            int n=Integer.parseInt(t.trim());

            String stockLine=bf.readLine();
            //if (stockLine == null || stockLine.trim().isEmpty()) break;

            st=new StringTokenizer(stockLine);
            int[] stocks=new int[n];
            for(int i=0;i<n;i++){
                stocks[i]=Integer.parseInt(st.nextToken());
            }

            ArrayList<Integer> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                int stock=stocks[i];
                int pos= Collections.binarySearch(list,stock);

                if(pos<0) pos=-(pos+1);

                if(pos==list.size()){
                    list.add(stock);
                }else{
                    list.set(pos,stock);
                }
            }

            sb.append(list.size()+"\n");

        }


        System.out.println(sb);


    }
}