import java.util.*;


public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int T=sc.nextInt();
        int[] arr=new int[T];
        int max=0;
        for(int i=0;i<T;i++){
            arr[i]=sc.nextInt();
            max=Math.max(max,arr[i]);
        }

        List<Integer>[] graph=new ArrayList[10];

        for(int i=0;i<10;i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(7);
        graph[1].add(2); graph[1].add(4);
        graph[2].add(1); graph[2].add(3); graph[2].add(5);
        graph[3].add(2); graph[3].add(6);
        graph[4].add(1); graph[4].add(5); graph[4].add(7);
        graph[5].add(2); graph[5].add(4); graph[5].add(6); graph[5].add(8);
        graph[6].add(3); graph[6].add(5); graph[6].add(9);
        graph[7].add(4); graph[7].add(8); graph[7].add(0);
        graph[8].add(5); graph[8].add(7); graph[8].add(9);
        graph[9].add(6); graph[9].add(8);

        long[][] dp=new long[max+1][10]; //dp[i][num]: 길이가 i이고, 마지막 숫자가 num인 비밀번호의 개수
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1; // 길이 1일 때 각 숫자는 1개씩 가능
        }


        for(int i=2;i<=max;i++){
            for(int j=0;j<=9;j++){
                for(int num:graph[j]){
                    dp[i][num]=(dp[i][num]+dp[i-1][j])%1234567;
                }
            }
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<T;i++){
            long sum=0;
            for(int j=0;j<=9;j++){
                sum=(sum+dp[arr[i]][j])%1234567;
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}