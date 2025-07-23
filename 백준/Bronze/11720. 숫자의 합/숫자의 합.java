import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());//첫번째 줄
        
        int[] a=new int[n];
        char[] b=new char[n];
        int sum=0;
        
        String s=br.readLine();
        for(int i=0;i<n;i++) {
        	b[i]=s.charAt(i); //char배열
        	a[i]=((int)b[i]-'0'); //char을 int로 변환
        	
        }
        
        for(int i=0;i<n;i++) {
        	sum+=a[i];
        }
        
	    System.out.println(sum);   
    }
}