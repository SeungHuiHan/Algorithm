import java.util.*;

public class Main{
    public static void main(String[] args){
       Scanner sc=new Scanner(System.in);

        int T=sc.nextInt();
        sc.nextLine();

        for(int i=0;i<T;i++){
            Stack<Character> stack=new Stack<>();

            String input=sc.nextLine();
            boolean t=true;

            for(int j=0;j<input.length();j++){
                char c=input.charAt(j);

                if(c=='('){
                    stack.push(c);
                }else{
                    if(stack.empty()){
                        t=false;
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }

            if(t && stack.empty()){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}