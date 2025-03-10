import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        Map<String,Integer> map=new TreeMap<>();

        int N=Integer.parseInt(bf.readLine());

        for(int i=0;i<N;i++){
            String[] input=bf.readLine().split("\\.");

            map.put(input[1],map.getOrDefault(input[1],0)+1);
        }

        StringBuilder sb=new StringBuilder();
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            sb.append(entry.getKey()+" "+entry.getValue());
            sb.append("\n");
        }

        System.out.println(sb);
    }
}