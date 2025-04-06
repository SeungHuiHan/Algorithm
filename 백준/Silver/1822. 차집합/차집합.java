import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int nA = sc.nextInt();
        int nB = sc.nextInt();

        int[] A = new int[nA];
        for (int i = 0; i < nA; i++) {
            A[i] = sc.nextInt();
        }

        HashSet<Integer> B = new HashSet<>();
        for (int i = 0; i < nB; i++) {
            B.add(sc.nextInt());
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nA; i++) {
            if (!B.contains(A[i])) {
                result.add(A[i]);
            }
        }

        if (result.size() == 0) {
            System.out.println(0);
        } else {
            Collections.sort(result);
            System.out.println(result.size());
            StringBuilder sb = new StringBuilder();
            for (int x : result) {
                sb.append(x).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
