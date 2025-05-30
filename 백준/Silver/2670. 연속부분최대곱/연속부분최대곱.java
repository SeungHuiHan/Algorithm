import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        double[] arr=new double[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextDouble();
        }


        double max=arr[0];
        double current=arr[0];
        for(int i=1;i<N;i++){
            current=Math.max(arr[i],current*arr[i]);
            max=Math.max(max,current);
        }


        System.out.printf("%.3f",max);

    }
}