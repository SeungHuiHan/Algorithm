import java.util.*;
import java.io.*;

public class Main{
    
    private static int N,K;
    private static int[] arr;
    
    public static void main(String[] args)throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st=new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        
        arr=new int[N];
        int max=0;
        int min=Integer.MIN_VALUE;
        
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(bf.readLine());
            min=Math.min(min,arr[i]);
            max=Math.max(max,arr[i]);
        }
        
        Arrays.sort(arr);
        
        int left=min;
        int right=max+K;
        int answer=0;
        while(left<=right){
            int mid=(left+right)/2;
            
            if(canCut(mid)){
                left=mid+1;
                answer=mid;
            }else{
                right=mid-1;
            }
        }
        
        System.out.println(answer);
        
    }
    
    private static boolean canCut(int mid){
        int temp=K;
        for(int a:arr){
            if(a>mid) continue;
            temp-=(mid-a);
            if(temp<0) break;
        }
        
        return temp>=0;
    }
}