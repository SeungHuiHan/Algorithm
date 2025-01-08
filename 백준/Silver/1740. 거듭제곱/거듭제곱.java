import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        long N=sc.nextLong();
        long result=0;
        long power=1;

        // 이진수를 3의 제곱수로 변환
        while(N>0){
            if((N&1)==1){
                result+=power;
            }
            power*=3; //3제곱수
            N>>=1;// N을 오른쪽으로 한 비트 이동
        }

        System.out.println(result);
    }

}