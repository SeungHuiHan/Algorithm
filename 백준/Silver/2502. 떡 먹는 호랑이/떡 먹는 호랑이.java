import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int D=sc.nextInt();
        int K=sc.nextInt();
        
        //a[D]*A+b[D]*B=K
        int[] a=new int[D+1]; //A계수
        int[] b=new int[D+1]; //B계수
        int[]dp=new int[D+1];
        
        a[1]=1;
        a[2]=0;
        b[1]=0;
        b[2]=1;
        
        for(int i=3;i<=D;i++){
            a[i]=a[i-1]+a[i-2];
            b[i]=b[i-1]+b[i-2];
        }
        
        for(int A=1;A<=K / a[D];A++){
            
            int temp=K-a[D]*A;
            
            if(temp%b[D]==0){
                int B=temp/b[D];
                
                System.out.println(A);
                System.out.println(B);
                return;
            }
        }
        
    }
}