import java.util.*;

public class Main {
    private static int N;
    private static String expression;
    private static int maxResult = Integer.MIN_VALUE;
    private static int[] numbers;
    private static char[] operators;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        expression = sc.nextLine();
        sc.close();
        
        int numCount = (N +1)/2;
        int opCount = (N-1)/2;
        numbers = new int[numCount];
        operators = new char[opCount];
        
        for(int i=0;i<N;i++){
            if(i%2 ==0){
                numbers[i/2] = expression.charAt(i) - '0';
            }
            else{
                operators[i/2] = expression.charAt(i);
            }
        }
        
        dfs(0, numbers[0]);
        
        System.out.println(maxResult);
    }

    //재귀적으로 모든 가능한 괄호의 조합을 탐색
    private static void dfs(int opIndex, int currentTotal){
        if(opIndex >= operators.length){
            maxResult = Math.max(maxResult, currentTotal);
            return;
        }
        
        // Option 1: 괄호를 추가하지 않는 경우
        int nextTotal = compute(currentTotal, operators[opIndex], numbers[opIndex +1]);
        dfs(opIndex +1, nextTotal);
        
        // Option 2: 괄호를 추가하는 경우 (다음 연산자가 있는 경우)
        if(opIndex +1 < operators.length){
            // 현재 연산자와 다음 연산자를 괄호로 묶어서 먼저 계산
            int temp = compute(numbers[opIndex +1], operators[opIndex +1], numbers[opIndex +2]);
            // 현재 연산자에 괄호로 묶인 결과를 적용
            int newTotal = compute(currentTotal, operators[opIndex], temp);
            dfs(opIndex +2, newTotal);
        }
    }
    
  
    //연산자와 계산
    private static int compute(int a, char op, int b){
        switch(op){
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
        }
        return 0; 
    }
}
