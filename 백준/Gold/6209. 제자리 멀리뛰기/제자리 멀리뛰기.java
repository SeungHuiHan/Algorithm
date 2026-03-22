import java.util.*;

public class Main{
    
    private static int d,n,m;
    private static long[] distances;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        d=sc.nextInt();
        n=sc.nextInt();
        m=sc.nextInt();
        distances=new long[n];
        for(int i=0;i<n;i++){
            distances[i]=sc.nextLong();
        }
        
        Arrays.sort(distances);
        
        long left=0;
        long right=d;
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
    
    private static boolean canCut(long mid){ //mid: 가장 최소거리
        int count=0;
        long prev=0;
        
        for(long d:distances){
            if(d-prev<mid){
                count++;
                
            }else{
                prev=d;
            }
        }
        
        return count<=m;
    }
}