import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st=new StringTokenizer(br.readLine());
        String s=br.readLine();
        
        int[] a=new int[26];
        char[] b=new char[s.length()];
        
        //알파벳 26
        for(int i=0;i<a.length;i++) {
        	a[i]=-1;
        }
	        
        for(int i=0;i<s.length();i++) {
        	b[i]=s.charAt(i);
        }
        
        //a=(int)b-'97'=0
        
        for(int i=0;i<26;i++) {
        	for(int j=0;j<s.length();j++) {
        		if(a[i]!=-1) //첫번째 온 문자만 체크
        			break;
        		if(((char)(97+i))==b[j])
        			a[i]=j;
        	}
        	
        }
        
        for(int i=0;i<26;i++) {
        	System.out.print(a[i]+" ");
        }
        
	    }

	
}