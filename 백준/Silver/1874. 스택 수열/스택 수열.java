import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Stack<Integer> stack=new Stack<>();

        StringBuilder sb=new StringBuilder();

        int n=sc.nextInt();
        int num=1;
        for(int i=0;i<n;i++){
            int target=sc.nextInt();

            if(target>=num){
                for(int j=num;j<=target;j++){
                    stack.push(j);
                    sb.append("+").append("\n");
                    num++;
                }
                stack.pop();
                sb.append("-").append("\n");
            }else{
                if(!stack.isEmpty()){
                    while(stack.peek()!=target){

                        stack.pop();
                        sb.append("-").append("\n");
                        if(stack.isEmpty()){
                            System.out.println("NO");
                            return ;
                        }
                    }
                    stack.pop();
                    sb.append("-").append("\n");
                }else{
                    System.out.println("NO");
                    return;
                }

            }

        }

        System.out.println(sb);

    }
}