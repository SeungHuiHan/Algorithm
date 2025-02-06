import java.util.*;

//9,876,543,210이 줄어드는 수 끝임
//약 2,100,000,000가 Integer 범위
public class Main {
    private static ArrayList<Long> numbers=new ArrayList<>();

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();

        for(int i=0;i<10;i++){
            backtracking(i,i);
        }


        Collections.sort(numbers);

        if(N>numbers.size())
            System.out.println(-1);
        else
            System.out.println(numbers.get(N-1));

    }

    //줄어드는 수 - 순서에 상관없이 일단 구하기
    private static void backtracking(long num,int lastNum){
        numbers.add(num);

        for(int nextNum=0;nextNum<lastNum;nextNum++){
            backtracking(10*num+nextNum,nextNum);
        }

    }
}