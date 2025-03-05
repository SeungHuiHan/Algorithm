import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
         BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        Map<String,Integer> map=new TreeMap<>();

        int N=Integer.parseInt(bf.readLine());
        for(int i=0;i<N;i++){
            String input=bf.readLine();
            map.put(input,map.getOrDefault(input,0)+1);
        }

        String maxS="";
        int maxCount=0;
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(maxCount<entry.getValue()){
                maxS=entry.getKey();
                maxCount=entry.getValue();
            }
        }

        System.out.println(maxS);
    }
}