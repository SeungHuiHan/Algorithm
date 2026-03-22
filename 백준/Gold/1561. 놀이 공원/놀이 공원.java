import java.util.*;

public class Main{
    
    private static long N;
    private static int M;
    private static int[] times;
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextLong();
        M=sc.nextInt();
        
        int max=0;
        times=new int[M];
        for(int i=0;i<M;i++){
            times[i]=sc.nextInt();
            max=Math.max(max,times[i]);
        }
        if(N<=M){
            System.out.println(N);
            return;
        }
        
        long left=1;
        long right=max*N;
        long answer=0;
        while(left<=right){
            long mid=(left+right)/2;
            
            if(canCut(mid)){
                right=mid-1;
                answer=mid;
            }else{
                left=mid+1;
            }
            
            
        }
        
        int before=M;
        for(int i=0;i<M;i++){
            before+=(answer-1)/times[i];
            
        }
        
        for(int i=0;i<M;i++){
            if(answer%times[i]==0){
                before++;
                if(before==N){
                    System.out.println(i+1);
                    return;
                }
            }
            
        }
        
        
        System.out.println(answer);
        
    }
    
    private static boolean canCut(long mid){
        long count=M; //초기 탑승자 
        
        for(int i=0;i<M;i++){
            count+=mid/times[i];
            
        }
        
        return count>=N;
    }
}