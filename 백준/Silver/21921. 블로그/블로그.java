import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int X=sc.nextInt();

        int[] arr=new int[N];
        for(int i=0;i<N;i++)
            arr[i]=sc.nextInt();

        int start=0;
        int total=0;
        int maxVisit=0;
        int count=1;
        for(int end=0;end<N;end++){
            total+=arr[end];

            if(end-start+1==X){
                if(maxVisit==total) count++;
                else if(maxVisit<total) {
                    maxVisit = total;
                    count=1;
                }
                total-=arr[start];
                start++;
            }
        }

        if(maxVisit==0) System.out.println("SAD");
        else {
            System.out.println(maxVisit);
            System.out.print(count);
        }
    }
}