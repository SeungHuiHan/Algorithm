import java.io.*;
import java.util.*;


public class Main {
    private static int N, M;
    private static boolean[] visited;
    private static ArrayList<Integer>[] partyList;
    private static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        partyList = new ArrayList[M];

        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) partyList[i] = new ArrayList<>();

        st = new StringTokenizer(bf.readLine());
        int T = Integer.parseInt(st.nextToken());
        int[] truth = new int[T];
        for (int i = 0; i < T; i++) {
            truth[i] = Integer.parseInt(st.nextToken());
        }

        // 파티 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[] partyPeople = new int[num];
            for (int j = 0; j < num; j++) {
                partyPeople[j] = Integer.parseInt(st.nextToken());
                partyList[i].add(partyPeople[j]);
            }

            // 파티 사람들 연결
            for (int j = 0; j < num; j++) {
                for (int k = j + 1; k < num; k++) {
                    graph[partyPeople[j]].add(partyPeople[k]);
                    graph[partyPeople[k]].add(partyPeople[j]);
                }
            }
        }

        // 진실 아는 사람들 DFS 전파
        for (int t =0;t<truth.length;t++) {
            dfs(truth[t]);
        }

        // 파티 검사
        int result = 0;
        for (int i = 0; i < M; i++) {
            boolean canLie = true;
            for (int person : partyList[i]) {
                if (visited[person]) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) result++;
        }

        System.out.println(result);
    }

    static void dfs(int current) {
        visited[current] = true;
        for (int next : graph[current]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
