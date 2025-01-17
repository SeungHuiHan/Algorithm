import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int N=sc.nextInt();
        int K=sc.nextInt();
        int[] kinder=new int[N];
        
        for(int i=0;i<N;i++){
            kinder[i]=sc.nextInt();
        }
        
        int[] heightDiffer=new int[N-1];
        for(int i=0;i<N-1;i++){
            heightDiffer[i]=kinder[i+1]-kinder[i];
        }
        
        Arrays.sort(heightDiffer);
        
        int sum=0;
        for(int i=0;i<N-K;i++){
            sum+=heightDiffer[i];
        }
        
        System.out.println(sum);
    }
}