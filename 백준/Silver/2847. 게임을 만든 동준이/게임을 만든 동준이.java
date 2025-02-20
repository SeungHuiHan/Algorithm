import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int count=0;
        int[] arr=new int[N];
        for(int i=0;i<N;i++){
            int current=sc.nextInt();
            arr[i]=current;
        }
        
       
       
        for (int i = N - 2; i >= 0; i--) { 
            if (arr[i] >= arr[i + 1]) { 
                int diff = arr[i] - arr[i + 1] + 1;  // 감소할 차이 계산
                count += diff;  // 감소 횟수 누적
                arr[i] -= diff;  // 점수 감소
            }
        }


        System.out.println(count);
    }
}