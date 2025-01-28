import java.util.*;
public class Main{
    public static void main(String[] args){
         Scanner sc=new Scanner(System.in);

        int K=sc.nextInt();
        int bit=Integer.highestOneBit(K);
        if(bit!=K){
            bit*=2;
        }

        // 2. 최소 쪼개기 횟수 계산
        int splitCount = 0;
        int temp = bit;

        // 초콜릿을 쪼개면서 K를 구성
        while (K > 0) {
            if (temp <= K) {
                K -= temp; // 초콜릿 크기를 K에서 뺌
            } else {
                temp /= 2; // 초콜릿을 반으로 쪼갬
                splitCount++;
            }
        }

        // 결과 출력
        System.out.println(bit+ " " + splitCount);
    }
}