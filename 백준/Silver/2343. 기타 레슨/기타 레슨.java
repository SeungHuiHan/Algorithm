import java.util.*;

public class Main{
    private static int N,M;
    private static int[] lessons;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        N=sc.nextInt();
        M=sc.nextInt();
        
        lessons=new int[N];
        int max=0;
        for(int i=0;i<N;i++){
            lessons[i]=sc.nextInt();
            max=Math.max(max,lessons[i]);
        }
        
        int left=max;
        int right=Arrays.stream(lessons).sum();
        int answer=0;
        while(left<=right){
            int mid=(left+right)/2;
            
            if(canCut(mid)){
                answer=mid;
                right=mid-1;
                
            }else{
                left=mid+1;
            }
        }
        
        System.out.println(answer);
        
    }
    
    private static boolean canCut(int mid){
        int count=1;
        int midCopy=mid;
        
        for(int lesson:lessons){
            if(midCopy<lesson){
                midCopy=mid;
                count++;
            }
            
            midCopy-=lesson;
        }
        
        return count<=M;
    }
}