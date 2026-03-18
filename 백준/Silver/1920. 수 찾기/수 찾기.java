import java.util.*;

public class Main{ 
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] narr=new int[N];
        for(int i=0;i<N;i++){
            narr[i]=sc.nextInt();
        }
        
        int M=sc.nextInt();
        int[] marr=new int[M];
        for(int i=0;i<M;i++){
            marr[i]=sc.nextInt();
        }
        
        Arrays.sort(narr);
        
        for(int m:marr){
            int left=0;
            int right=N-1;
            boolean flag=false;
            while(left<=right ){
                int mid=(left+right)/2;
               
               
                if(narr[mid]==m){
                    flag=true;
                    System.out.println(1);
                    break;
                }else if(narr[mid]>=m){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
                
                
            }
            
            if(!flag)
                System.out.println(0);
                 
                 
        }
    }
    
}