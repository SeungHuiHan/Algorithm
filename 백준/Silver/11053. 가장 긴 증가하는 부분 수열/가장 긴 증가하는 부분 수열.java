import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

       
        
        int N=Integer.parseInt(bf.readLine());
        int[] arr=new int[N];
        
         StringTokenizer st=new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        
        ArrayList<Integer> list=new ArrayList<>();
        for(int target:arr){
            
            int pos=Collections.binarySearch(list,target);
            if(pos<0) pos=-(pos+1);
            
            if(pos==list.size()){
                list.add(target);
            }else{
                list.set(pos,target);
            }
        }
        
        System.out.println(list.size());
        
    }
}