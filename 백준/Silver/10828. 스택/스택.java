import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(bf.readLine());
        Stack<Integer> stack=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<N;i++){
            String s=bf.readLine();

            if(s.equals("pop")){
                if(stack.isEmpty()) sb.append(-1).append("\n");
                else sb.append(stack.pop()).append("\n");
            }else if(s.equals("size")){
                sb.append(stack.size()).append("\n");
            }else if(s.equals("empty")){
                if(stack.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }else if(s.equals("top")){
                if(stack.isEmpty()) sb.append(-1).append("\n");
                else sb.append(stack.peek()).append("\n");
            }else{
                String[] s1=s.split(" ");
                stack.push(Integer.parseInt(s1[1]));
            }

        }

        if(sb.length()!=0)
            sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}