import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 상근이
            int M = Integer.parseInt(st.nextToken()); // 선영이

            if (N == 0 && M == 0) break;

            int[] sang = new int[N];
            int[] sun = new int[M];

            for (int i = 0; i < N; i++) {
                sang[i] = Integer.parseInt(br.readLine());
            }

            for (int i = 0; i < M; i++) {
                sun[i] = Integer.parseInt(br.readLine());
            }

            int count = 0;
            int i = 0, j = 0;

            while (i < N && j < M) {
                if (sang[i] == sun[j]) {
                    count++;
                    i++;
                    j++;
                } else if (sang[i] < sun[j]) {
                    i++;
                } else {
                    j++;
                }
            }

            System.out.println(count);
        }
    }
}
