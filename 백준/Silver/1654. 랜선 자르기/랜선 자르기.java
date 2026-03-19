import java.util.*;

public class Main{
    
    private static long[] arr;
    private static int N;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int K=sc.nextInt();
        N=sc.nextInt();
        
        arr=new long[K];
        for(int i=0;i<K;i++){
            arr[i]=sc.nextLong();
        }
        Arrays.sort(arr);
        
        long left=1;
        long right=arr[K-1];
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
        int count=0;
        
        for(long a:arr){
            count+=a/mid;
        }
        return count>=N?true:false;
    }
    
}