import java.util.*;
//최소의 최대
public class Main{
    
    private static int N,C;
    private static int[] homes;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        N=sc.nextInt();
        C=sc.nextInt();
        homes=new int[N];
        for(int i=0;i<N;i++){
            homes[i]=sc.nextInt();
        }
        
        Arrays.sort(homes);
        
        long left=1;
        long right=homes[N-1];
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
        int count=1;
        int prev=homes[0];
        //mid가 최소의 거리라고 생각하면.. mid보다 작은 거리가 나오면 안된다.
        for(int i=1;i<N;i++){
            if(homes[i]-prev>=mid) {
                count++;
                 prev=homes[i]; //설치했을떄만
            }
        }
        
        return count>=C;
    }
}