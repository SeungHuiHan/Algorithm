import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();

       //char는 정수 비교가 가능 ('1' < '2' → true)
        Stack<Character> stack=new Stack<>();

        int N=sc.nextInt();
        int K=sc.nextInt();
        sc.nextLine();


        String input=sc.nextLine();
        int count=0;
        for(char c:input.toCharArray()){
            while(!stack.isEmpty() && count<K && stack.peek()<c){
                stack.pop();
                count++;
            }
            stack.push(c);
        }
       
        for(int i=0;i<N-K;i++){
            sb.append(stack.get(i));
        }

        System.out.println(sb);

    }
}