import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        StringBuilder sb = null;
        String A=st.nextToken();
        String B=st.nextToken();
        
        sb=new StringBuilder();
        for(int i=2;i>=0;i--) {
        	sb.append(A.charAt(i));        	   	
        }
       
        int a=Integer.parseInt(sb.toString());
        
        sb=new StringBuilder();
        for(int i=2;i>=0;i--) {       
        	sb.append(B.charAt(i));
        }
        
        int b=Integer.parseInt(sb.toString());
        
        if(a>b)
        	System.out.print(a);
        else
        	System.out.print(b);
        
        
        
	}

}
