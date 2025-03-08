import java.util.*;
import java.io.*;

//(100+1+ | 01)+
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int T=Integer.parseInt(bf.readLine());

        for(int i=0;i<T;i++){
            String s=bf.readLine();

            if(s.matches("(100+1+|01)+"))
                sb.append("YES");
            else
                sb.append("NO");
            sb.append("\n");

        }

        System.out.println(sb);

        
    }
}