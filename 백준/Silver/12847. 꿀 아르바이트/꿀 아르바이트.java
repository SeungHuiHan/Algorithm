import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int m=sc.nextInt();

        int [] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        int start=0;
        long maxSum=0;
        long total=0;
        for(int end=0;end<n;end++){
            total+=arr[end];

            while(end-start+1>m){

                total-=arr[start];
                start++;
            }

            maxSum=Math.max(maxSum,total);
        }

        System.out.println(maxSum);
    }
}