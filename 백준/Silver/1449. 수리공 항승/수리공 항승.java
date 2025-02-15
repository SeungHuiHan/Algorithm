import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int L=sc.nextInt();
        int[] arr=new int[N];
        int[] arr1=new int[N-1];

        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }

        Arrays.sort(arr);

        int count = 0; // 필요한 테이프 개수
        int lastCovered = 0; // 현재 사용한 테이프가 커버하는 마지막 위치

        for (int i = 0; i < N; i++) {
            // 현재 위치가 마지막으로 덮은 범위를 넘어갔다면 새로운 테이프 사용
            if (i == 0 || arr[i] > lastCovered) {
                count++; // 테이프 개수 증가
                lastCovered = arr[i] + (L - 1); // 새로운 테이프가 덮을 수 있는 범위
            }
        }

        System.out.println(count);

    }
}