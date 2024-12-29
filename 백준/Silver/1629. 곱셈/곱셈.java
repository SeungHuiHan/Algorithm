import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());


        int A=Integer.parseInt(st.nextToken());
        int B=Integer.parseInt(st.nextToken());
        int C=Integer.parseInt(st.nextToken());


        System.out.println(module(A,B,C));
    }

    private static long module(int A,int B,int C){
        if(B==0) return 1;
        if(B==1) return A%C;

        long half=module(A,B/2,C);
        long result=half*half%C;

        if(B%2==1){//B가 홀수일때
            result=result*A%C;
        }

        return result;

    }
}