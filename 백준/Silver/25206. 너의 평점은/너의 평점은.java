import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        Map<String,Double> map=new HashMap<>();
        map.put("A+",4.5);
        map.put("A0",4.0);
        map.put("B+",3.5);
        map.put("B0",3.0);
        map.put("C+",2.5);
        map.put("C0",2.0);
        map.put("D+",1.5);
        map.put("D0",1.0);
        map.put("F",0.0);
        
        Double totalScore=0.0;
        Double credit=0.0;
        for(int i=0;i<20;i++){
            String[] input=bf.readLine().split(" ");
            if(input[2].equals("P")) continue;
            totalScore+=Double.parseDouble(input[1])*map.get(input[2]);
            credit+=Double.parseDouble(input[1]);
        }
        
        System.out.println(credit==0?0.0:(Double)totalScore/credit);
        
        
    }
} 