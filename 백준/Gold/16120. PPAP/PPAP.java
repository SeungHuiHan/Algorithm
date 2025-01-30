import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Stack<Character> stack=new Stack<>();

        String s=sc.nextLine();

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            stack.push(c);

            int n=stack.size();
            if(n>=4){
                if(stack.get(n-4)=='P' && stack.get(n-3)=='P' && stack.get(n-2)=='A' && stack.get(n-1)=='P'){
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();

                    stack.push('P');

                }
            }
            
        }

        if(stack.size()==1 && stack.peek()=='P')
            System.out.println("PPAP");
        else
            System.out.println("NP");

    }
}