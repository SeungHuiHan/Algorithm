import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st;
        int N=Integer.parseInt(bf.readLine());
        boolean[][] gradeCheck = new boolean[N][6]; // [책상 번호][grade]

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            gradeCheck[i][a] = true;
            gradeCheck[i][b] = true;
        }

        int maxCount = 0;
        int resultGrade = 0;

        // 각 등급에 대해 확인
        for (int grade = 1; grade <= 5; grade++) {
            int left = 0;
            int right = 0;
            int count = 0;

            while (right < N) {
                if (gradeCheck[right][grade]) {
                    right++;
                    count = right - left;
                    if (count > maxCount || (count == maxCount && grade < resultGrade)) {
                        maxCount = count;
                        resultGrade = grade;
                    }
                } else {
                    // 현재 책상에 해당 grade 없음 → 왼쪽 포인터 이동
                    right++;
                    left = right;
                }
            }
        }

        System.out.println(maxCount + " " + resultGrade);
    }
}