import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        Stack<Integer> stack=new Stack<>();
        
        int n=sc.nextInt();
        
        for(int i=0;i<n;i++){
            int n1=sc.nextInt();
            if(n1==0){
                stack.pop();
            }else{
                stack.push(n1);
            }
        }
        
        int answer=0;
        while(!stack.isEmpty()){
            answer+=stack.pop();
        }
        System.out.println(answer);
    }
}