import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int N=sc.nextInt();
        int K=sc.nextInt();

        long left=1;
        long right=K; //실제 오름차순 배열은 1,2,2,3,3,,,이렇게 작은수부터 나열되기 때문에 구하는 값이 K보다 클 수가 없음
        long answer=0;

        while(left<=right){
            long mid=(left+right)/2;
            long count=0;

            //i*j<=mid -> j<=mid/i, i*j의 최대값은 N임
            for(int i=1;i<=N;i++){
                count+=Math.min(N,mid/i);
            }


            if(count>=K){
                answer=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }

        }

        System.out.println(answer);
    }
}