import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int count=0;

         while (n > 0) {
            if (n % 5 == 0) {  // 5의 배수이면 바로 나누기
                count += n / 5;
                break;
            }
            n -= 2;  // 5의 배수가 될 때까지 2를 빼줌
            count++;

            if (n < 0) {  // 거슬러 줄 수 없는 경우
                count = -1;
                break;
            }
        }


        System.out.println(count);
    }
}