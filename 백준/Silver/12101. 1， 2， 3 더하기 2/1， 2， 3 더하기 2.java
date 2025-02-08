import java.util.*;

public class Main{
    private static ArrayList<String> list=new ArrayList<>();
    private static int N;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        int K=sc.nextInt();

        backtracking(0,"");

        Collections.sort(list);

        if(list.size()<K){
            System.out.println(-1);
        }else
            System.out.println(list.get(K-1));

    }

    private static void backtracking(int sum,String s){
        if(sum==N){
            if(!s.isEmpty()) list.add(s);

            return;
        }

        for(int i=1;i<=3;i++){
           if (sum + i <= N) { // sum이 N을 초과하면 호출하지 않음
                if (s.isEmpty()) {
                    backtracking(sum + i, s + i); // 처음 값은 숫자만 추가
                } else {
                    backtracking(sum + i, s + "+" + i); // 이후 값은 "+" 포함
                }
            }
        }
    }
}