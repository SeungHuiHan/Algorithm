import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        
        int line = 1;  // 몇 번째 대각선 그룹인지
        int sum = 0;
        
        // 대각선 찾기
        while (sum + line < X) {
            sum += line;
            line++;
        }

        int pos = X - sum; // 대각선에서 몇 번째 원소인지

        int numerator, denominator;
        if (line % 2 == 0) {
            // 짝수 라인 → 위에서 아래로
            numerator = pos;
            denominator = line - pos + 1;
        } else {
            // 홀수 라인 → 아래에서 위로
            numerator = line - pos + 1;
            denominator = pos;
        }

        System.out.println(numerator + "/" + denominator);
    }
}
