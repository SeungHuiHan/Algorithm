import java.util.*;

public class Main {
    static int n, m, k;
    static List<Set<Integer>> quests = new ArrayList<>();
    static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 사용할 수 있는 키 개수
        m = sc.nextInt(); // 퀘스트 수
        k = sc.nextInt(); // 퀘스트당 필요한 스킬 수

        for (int i = 0; i < m; i++) {
            Set<Integer> q = new HashSet<>();
            for (int j = 0; j < k; j++) {
                q.add(sc.nextInt());
            }
            quests.add(q);
        }

        // 1부터 2n까지 중 n개 선택 (조합)
        backtrack(new ArrayList<>(), 1);
        System.out.println(max);
    }

    // 조합 백트래킹
    private static void backtrack(List<Integer> picked, int start) {
        if (picked.size() == n) {
            check(picked);
            return;
        }

        for (int i = start; i <= 2 * n; i++) {
            picked.add(i);
            backtrack(picked, i + 1);
            picked.remove(picked.size() - 1);
        }
    }

    // 현재 선택한 스킬 세트로 몇 개 퀘스트를 깰 수 있는지 확인
    private static void check(List<Integer> selected) {
        Set<Integer> skillSet = new HashSet<>(selected);
        int count = 0;

        for (Set<Integer> quest : quests) {
            if (skillSet.containsAll(quest)) {
                count++;
            }
        }

        max = Math.max(max, count);
    }
}
