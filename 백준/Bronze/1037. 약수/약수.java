import java.util.*;


public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        
        int N=sc.nextInt();
        long[] arr=new long[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);

        
        System.out.println(arr[0]*arr[N-1]);
    }
}