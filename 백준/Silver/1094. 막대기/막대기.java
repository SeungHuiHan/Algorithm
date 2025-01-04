import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int count=0;

        while(n>0){
            if((n&1)==1) count++; // 현재 비트가 1이면 카운트
            n>>=1;  // X를 오른쪽으로 한 비트 이동
        }

        System.out.println(count);
    }
}