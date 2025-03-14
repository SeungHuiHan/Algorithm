import java.util.*;

public class Main{
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();
        String T = sc.nextLine();

        System.out.println(canTransform(T, S) ? 1 : 0);
    }

    private static boolean canTransform(String current, String target) {
        if (current.equals(target)) {
            return true;
        }
        if (current.length() < target.length()) {
            return false;
        }

        // 경우 1: 마지막 문자가 'A'인 경우 → 'A' 제거
        if (current.charAt(current.length() - 1) == 'A') {
            if (canTransform(current.substring(0, current.length() - 1), target)) {
                return true;
            }
        }

        // 경우 2: 첫 번째 문자가 'B'인 경우 → 뒤집고 'B' 제거
        if (current.charAt(0) == 'B') {
            String reversed = new StringBuilder(current).reverse().toString();
            if (canTransform(reversed.substring(0, reversed.length() - 1), target)) {
                return true;
            }
        }

        return false;
    }
}