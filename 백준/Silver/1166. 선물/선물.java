import java.util.*;

public class Main{
    
    private static long N, L, W, H;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextLong();
        L = sc.nextLong();
        W = sc.nextLong();
        H = sc.nextLong();

        double left = 0.0;
        double right = Math.min(L, Math.min(W, H));
        double answer = 0.0;

        for (int i = 0; i < 100; i++) {
            double mid = (left + right) / 2;
            if (canFit(mid)) {
                answer = mid;
                left = mid;
        } else {
            right = mid;
        }    
}

        System.out.print( answer); 
    }

    private static boolean canFit(double a) {
        // 박스를 넣을 수 있는 개수 계산
        long count = (long)(L / a) * (long)(W / a) * (long)(H / a);
        return count >= N;
    }
}