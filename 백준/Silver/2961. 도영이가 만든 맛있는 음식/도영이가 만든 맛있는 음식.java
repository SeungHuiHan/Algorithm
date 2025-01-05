import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int N=sc.nextInt();
        int[][] zza=new int[N][2];
        
        for(int i=0;i<N;i++){
            zza[i][0]=sc.nextInt();
            zza[i][1]=sc.nextInt();
        }
        
        int minDifference=Integer.MAX_VALUE;
        
        for(int mask=1;mask<(1<<N);mask++ ){
            int sSum=1;
            int bSum=0;
            
            for(int i=0;i<N;i++){
                if((mask & (1<<i)) !=0){
                    sSum*=zza[i][0];
                    bSum+=zza[i][1];
                }
            }

            int difference=Math.abs(sSum-bSum);
            minDifference=Math.min(minDifference,difference);
            
        }
        System.out.println(minDifference);    
    }
}