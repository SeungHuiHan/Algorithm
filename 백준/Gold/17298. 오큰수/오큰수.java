import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack =new Stack<>();

        int N=Integer.parseInt(br.readLine());
        int[] arr =new int[N];
        int[] result =new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
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