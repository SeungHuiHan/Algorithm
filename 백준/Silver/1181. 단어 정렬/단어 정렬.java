import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(bf.readLine());


        HashSet<String> set=new HashSet<>();

        for(int i=0;i<n;i++){
            set.add(bf.readLine());
        }
        ArrayList<String> list=new ArrayList<>(set);

        Collections.sort(list,(a, b)->{
            if (a.length() != b.length()) {
                return Integer.compare(a.length(), b.length()); // 길이로 비교
            }
            return a.compareTo(b);
        });

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<list.size();i++){
            sb.append(list.get(i));
            sb.append("\n");
        }

        System.out.println(sb);
    }
}