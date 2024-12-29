import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        int answer=0;

        int N=Integer.parseInt(bf.readLine());

        String[] arr=new String[N];

        for(int i=0;i<N;i++){
            arr[i]=bf.readLine();
        }



        for(int i=0;i<arr.length;i++){
            HashSet<Character> hash=new HashSet<>();
            char over=' ';
            boolean t=true;
            for(int j=0;j<arr[i].length();j++){
                char c=arr[i].charAt(j);
                if(hash.contains(c) && over!=c){
                    t=false;
                    break;
                }else if(!hash.contains(c)){
                    hash.add(c);
                    over=c;
                }
            }

            if(t) answer++;
        }

        System.out.println(answer);
    }
}