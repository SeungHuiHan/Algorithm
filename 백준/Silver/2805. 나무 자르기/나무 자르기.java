import java.util.*;

public class Main{
    
    private static int[] arr;
    private static long M;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int N=sc.nextInt();
        M=sc.nextLong();
        
        arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        
        int left=0;
        int right=1000000000;
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
        long answer=0;
        
        for(int a:arr){
            if(a-mid>0)
                answer+=(a-mid);
        }
        return answer>=M?true:false;
    }
}