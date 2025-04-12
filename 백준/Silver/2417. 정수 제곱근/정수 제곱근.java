import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = new BigInteger(sc.next());

        BigInteger left = BigInteger.ZERO;
        BigInteger right = n;
        BigInteger answer = BigInteger.ZERO;

        while (left.compareTo(right) <= 0) {
            BigInteger mid = left.add(right).divide(BigInteger.TWO);
            BigInteger midSquared = mid.multiply(mid);

            int cmp = midSquared.compareTo(n);
            if (cmp >= 0) {
                answer = mid;
                right = mid.subtract(BigInteger.ONE);
            } else {
                left = mid.add(BigInteger.ONE);
            }
        }

        System.out.println(answer);
    }
}
