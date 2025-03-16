import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(bf.readLine());

        for(int i=0;i<T;i++){
            String[] input=bf.readLine().split(" ");
            HashSet<String> animals=new HashSet<>();
            while(true){
                String s=bf.readLine();
                if(s.equals("what does the fox say?")) break;

                String[] s1=s.split(" ");
                animals.add(s1[2]);
            }

            StringBuilder sb=new StringBuilder();
            for(String a:input){
                if(!animals.contains(a)) sb.append(a+" ");
            }
            sb.deleteCharAt(sb.length()-1);


            System.out.println(sb);
        }
    }
}