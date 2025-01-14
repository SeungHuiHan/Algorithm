import java.util.*;

public class Main{
    private static int N,S;
    private static int[] arr;
    private static int count;
    private static int sum;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        S=sc.nextInt();

        arr=new int[N];

        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }

        for(int i=1;i<=N;i++){
            sum=0;
            backtracking(0,i);
        }

        System.out.println(count);

    }


    private static void backtracking(int current,int target){
        if(current==target){
            if(sum==S){
                count++;
            }
            return;
        }

        for(int i=current;i<N;i++){
                sum+=arr[i];
                backtracking(i+1,target);
                sum-=arr[i];
        }

    }
}