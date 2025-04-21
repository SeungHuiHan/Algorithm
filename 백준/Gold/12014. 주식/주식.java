import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        
        int T=Integer.parseInt(bf.readLine());
        for(int i=1;i<=T;i++){
            
            st=new StringTokenizer(bf.readLine());
            int N=Integer.parseInt(st.nextToken());
            int K=Integer.parseInt(st.nextToken());
            
            int[] stocks=new int[N];
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++){
                stocks[j]=Integer.parseInt(st.nextToken());
            }
            
            ArrayList<Integer> list=new ArrayList<>();
            for(int j=0;j<N;j++){
                int stock=stocks[j];
                int pos=Collections.binarySearch(list,stock);
                if(pos<0) pos=-(pos+1);
                
                
                if(pos==list.size()){
                    list.add(stock);
                }else{
                    list.set(pos,stock);
                }
            }
            
            sb.append("Case #").append(i).append("\n");
            int n=(list.size()>=K?1:0);
            sb.append(n).append("\n");
        }
        
        System.out.println(sb);
    }
}