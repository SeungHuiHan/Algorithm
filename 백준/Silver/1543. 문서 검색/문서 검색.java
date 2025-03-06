import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String document = sc.nextLine();
        String word = sc.nextLine();

        int count = 0;
        int index = 0;

        while (true) {
            index = document.indexOf(word, index); // 검색어 찾기
            if (index == -1) break; // 찾을 수 없으면 종료

            count++; // 발견된 횟수 증가
            index += word.length(); // 검색어 길이만큼 점프 (중복 방지)
        }

        System.out.println(count);
    }
}
