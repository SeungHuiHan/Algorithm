import java.util.*;

public class Main{
    private static int[][] nutrients; // 영양소 데이터
    private static int[] prices; // 가격 데이터
    private static int N; // 식재료 개수
    private static int minPrice = Integer.MAX_VALUE; // 최소 비용
    private static int[] minVolumes=new int[4]; // 최소 영양분
    private static int[] answer; // 최소 비용을 만족하는 조합
    private static int[] sumOfNutrients; // 현재 조합의 영양소 합계

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        sc.nextLine();
        prices = new int[N];
        nutrients = new int[N][4];
        sumOfNutrients = new int[4];

        String[] input =sc.nextLine().split(" ");
        for(int i=0;i<4;i++){
            minVolumes[i]=Integer.parseInt(input[i]);
        }


        // 입력 처리
        for (int i = 0; i < N; i++) {
            input = sc.nextLine().split(" ");
            for (int j = 0; j < 4; j++) {
                nutrients[i][j] = Integer.parseInt(input[j]);
            }
            prices[i] = Integer.parseInt(input[4]);
        }

        // 조합 탐색
        for (int i = 1; i <= N; i++) {
            backtracking(0, 0, 0, i, new int[i]);
        }

        // 결과 출력
        if (minPrice == Integer.MAX_VALUE) {
            System.out.println(-1); // 조건을 만족하는 조합이 없는 경우
        } else {
            System.out.println(minPrice);
            Arrays.sort(answer); // 결과를 사전순으로 정렬
            for (int n : answer) {
                System.out.print(n + " ");
            }
        }
    }

    private static void backtracking(int start, int count, int price, int target, int[] current) {
        // 조합 완성
        if (count == target) {
            // 조건 확인
            if (sumOfNutrients[0] >= minVolumes[0] && sumOfNutrients[1] >= minVolumes[1] &&
                    sumOfNutrients[2] >= minVolumes[2] && sumOfNutrients[3] >= minVolumes[3]) {
                // 최소 비용 갱신 또는 사전순 비교
                if (price < minPrice || (price == minPrice && isLexicographicallySmaller(current))) {
                    minPrice = price;
                    answer = current.clone(); // 현재 조합 저장
                }
            }
            return;
        }

        // 조합 생성
        for (int i = start; i < N; i++) {
            current[count] = i + 1; // 1부터 시작하는 번호 저장
            for (int j = 0; j < 4; j++) {
                sumOfNutrients[j] += nutrients[i][j];
            }

            // 백트래킹 재귀 호출
            backtracking(i + 1, count + 1, price + prices[i], target, current);

            // 복구 작업
            for (int j = 0; j < 4; j++) {
                sumOfNutrients[j] -= nutrients[i][j];
            }
        }
    }

    // 사전순 비교 함수
    private static boolean isLexicographicallySmaller(int[] current) {
        // 기존 결과가 없는 경우 항상 true
        if (answer == null) {
            return true;
        }
        for (int i = 0; i < current.length; i++) {
            if (i >= answer.length) {
                return false; // 비교 대상의 길이를 초과하면 false
            }
            if (current[i] != answer[i]) {
                return current[i] < answer[i]; // 사전순으로 더 작은 경우 true
            }
        }
        return current.length < answer.length; // 길이가 짧으면 사전순으로 더 작음
    }
}