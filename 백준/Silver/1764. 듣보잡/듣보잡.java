import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> unheard=new HashSet<>();
        ArrayList<String> answer=new ArrayList<>();

        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            unheard.add(br.readLine());
        }

        for(int i=0;i<M;i++){
            String unsee=br.readLine();

            if(unheard.contains(unsee)){
                answer.add(unsee);
            }
        }

        Collections.sort(answer);

        System.out.println(answer.size());
        for(String s:answer)
            System.out.println(s);
    }
}