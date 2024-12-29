import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Stack<Integer> stack =new Stack<>();

        int N=sc.nextInt();
        int[] arr =new int[N];
        int[] result =new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }

        for(int i=N-1;i>=0;i--){
            
            if(stack.isEmpty()){
                result[i]=-1;
            }else{
                while(!stack.isEmpty() && stack.peek()<=arr[i]){
                    stack.pop();
                }
                result[i]=stack.isEmpty()?-1:stack.peek();
            }
            
            stack.push(arr[i]);
        }
        
       StringBuilder sb=new StringBuilder();
        for(int i:result)
            sb.append(i).append(" ");

        System.out.println(sb);

    }
}