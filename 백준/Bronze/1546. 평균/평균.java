import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args)throws IOException{
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st=new StringTokenizer(br.readLine()," ");
		 int N=Integer.parseInt(st.nextToken());
	        double[] a=new double[N];
	        double max=0;
	        double sum=0;
	        
	        st=new StringTokenizer(br.readLine()," ");
	        //int[] q=new int[N];
	        for(int i=0;i<N;i++) {
	            int q=Integer.parseInt(st.nextToken());
	            a[i]=q;
	        }
	        
	        
	        for(int i=0;i<N;i++){
	            if(a[i]>max)
	                max=a[i];
	            
	        }
	        
	        for(int i=0;i<N;i++){
	            a[i]=a[i]/max*100;
	            //System.out.println(a[i]);
	            sum+=a[i];
	        }
	        
	        System.out.print(sum/N);
	        
	        
	        
	    }
	
}
