import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> queue=new ArrayDeque<>();

        int N=Integer.parseInt(bf.readLine());
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<N;i++){
            String s=bf.readLine();

            if(s.equals("pop")){
                if(queue.isEmpty()) sb.append(-1).append("\n");
                else sb.append(queue.pop()).append("\n");
            }else if(s.equals("size")){
                sb.append(queue.size()).append("\n");
            } else if(s.equals("empty")){
                if(queue.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else if(s.equals("front")){
                if(queue.isEmpty()) sb.append(-1).append("\n");
                else sb.append(queue.peek()).append("\n");
            } else if(s.equals("back")){
                if(queue.isEmpty()) sb.append(-1).append("\n");
                else sb.append(queue.getLast()).append("\n");
            } else {
                String[] sq=s.split(" ");
                queue.add(Integer.parseInt(sq[1]));
            }
        }

        if(sb.length()>1) sb.deleteCharAt(sb.length()-1);

        System.out.println(sb);

    }
}