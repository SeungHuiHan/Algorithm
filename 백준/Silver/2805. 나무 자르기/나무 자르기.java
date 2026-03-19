import java.util.*;

public class Main{
    private static long[] arr;
    private static Long M;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        M=sc.nextLong();
        
        long max=0;
        arr=new long[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextLong();
            max=Math.max(max,arr[i]);
        }
        
        long left=0;
        long right=max;
        long answer=0;
        
        while(left<=right){
            long mid=(left+right)/2;
            
            if(canCut(mid)){
                left=mid+1;
                answer=mid;
            }else{
                right=mid-1;
            }
        }
        
        System.out.println(answer);
    }
    
    private static boolean canCut(long mid){
        long len=0;
        for(long a:arr){
            if(a>mid) len+=(a-mid);
        }
        
        return len>=M?true:false;
    }
}