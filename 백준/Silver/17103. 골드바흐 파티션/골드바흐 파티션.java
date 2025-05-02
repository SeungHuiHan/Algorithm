import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        
        int T=Integer.parseInt(bf.readLine());
        int[] arr=new int[T];
        int N=0;
        for(int i=0;i<T;i++){
            arr[i]=Integer.parseInt(bf.readLine());
            N=Math.max(N,arr[i]);
        }
        
        boolean[] isPrime=new boolean[N+1];
        Arrays.fill(isPrime,true);
        isPrime[0]=isPrime[1]=false;
        
        for(int i=2;i*i<=N;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=N;j+=i){
                    isPrime[j]=false;
                }
            }
        }
        
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<T;i++){
            int count=0;
            int target=arr[i];
            int left=target/2;
            
            while(left>0){
                int right=target-left;
                
                if(isPrime[left] && isPrime[right]) count++;
                
                left--;
            }
            
            sb.append(count).append("\n");
        }
        
        System.out.println(sb);
    }
}