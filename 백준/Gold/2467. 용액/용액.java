import java.util.*;
import java.math.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int[] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }

        Arrays.sort(arr);
        int answer1=0;
        int answer2=0;
        int minAbs=Integer.MAX_VALUE; //차이 최소
        int left=0;
        int right=N-1;

        while(left<right){

            int sum=arr[left]+arr[right];

            if(Math.abs(sum)<minAbs){
                minAbs=Math.abs(sum);
                answer1=arr[left];
                answer2=arr[right];
            }

            if(sum>0){ // 두 원소 합이 양수일때
                right--;
            }else{
                left++;
            }

        }

        System.out.println(answer1+" "+answer2);

    }
}