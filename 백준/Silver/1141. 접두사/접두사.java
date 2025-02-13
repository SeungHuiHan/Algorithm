import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set=new HashSet<>();
        int N=Integer.parseInt(bf.readLine());

        String[] s=new String[N];
        for(int i=0;i<s.length;i++){
            s[i]=bf.readLine();
        }
        Arrays.sort(s,(a,b)-> Integer.compare(a.length(),b.length()));
        int count=N;
        for(int i=0;i<s.length-1;i++){
            for(int j=i+1;j<s.length;j++){
                if(s[j].startsWith(s[i])){
                    count--;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}