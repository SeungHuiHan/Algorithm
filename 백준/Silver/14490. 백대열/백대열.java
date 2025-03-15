import java.util.*;

public class Main{
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(":");

        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);

        int gcd = getGCD(a, b);  // 최대공약수 계산

        System.out.println((a / gcd) + ":" + (b / gcd));
    }

    // 유클리드 호제법을 이용한 최대공약수(GCD) 계산
    private static int getGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}