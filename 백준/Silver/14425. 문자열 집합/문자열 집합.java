import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        Set<String> set=new HashSet<>();
        for(int i=0;i<N;i++){
            set.add(bf.readLine());
        }
        
        int count=0;
        for(int i=0;i<M;i++){
            String s=bf.readLine();
            if(set.contains(s)) count++;
        }
        
        System.out.println(count);
    }
}