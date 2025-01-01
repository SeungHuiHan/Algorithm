import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int[] a=new int[N];

        for(int i=0;i<N;i++){
            a[i]=sc.nextInt();
        }

        Arrays.sort(a);
        int Max=0;
        int count=a.length;

        for(int i=0;i<N;i++){
            Max=Math.max(Max,a[i]*count);
            count--;
        }

        System.out.println(Max);
    }
}