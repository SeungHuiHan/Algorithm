import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        String[] arr=bf.readLine().split("");
        ArrayList<Integer> list=new ArrayList<>();

        boolean zero=false;
        for(int i=0;i<arr.length;i++){
            list.add(Integer.parseInt(arr[i]));
            if((Integer.parseInt(arr[i])==0) )zero=true;
        }
        if(!zero){
            System.out.println(-1);
            return;
        }

        Collections.sort(list,Collections.reverseOrder());

        int sum=0;
        for(int i=0;i<list.size()-1;i++){
            sum+=list.get(i);
        }

        StringBuilder sb=new StringBuilder();
        if(sum%3!=0){
            System.out.println(-1);
        }else{
            for(int n:list){
                sb.append(Integer.toString(n));
            }
            System.out.println(sb);
        }
        
    }
}