import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> A=new ArrayList<>();
        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> B=new ArrayList<>();
        for (int i = 0; i < N; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }


        Collections.sort(A, Collections.reverseOrder());
        Collections.sort(B);
        
        int sum=0;
        for (int i = 0; i < N; i++) {
            sum+=A.get(i)*B.get(i);
        }
        System.out.println(sum);
    }
}