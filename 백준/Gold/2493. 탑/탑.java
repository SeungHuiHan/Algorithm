import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<int[]> stack1=new Stack<>();
        Stack<int[]> stack2=new Stack<>();

        int N=Integer.parseInt(br.readLine());
        int[] reception=new int[N];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int n=Integer.parseInt(st.nextToken());
            stack1.push(new int[]{n,i});
        }

        while(!stack1.isEmpty()){
            int[] n=stack1.pop();
            stack2.push(new int[]{n[0],n[1]});

            if(!stack1.isEmpty()){
                int[] prev=stack1.peek();
                while(true){
                    if(stack2.isEmpty()) break;
                    else{
                        int[] current=stack2.peek();
                        if(prev[0]>=current[0]){
                            reception[current[1]]=prev[1]+1;
                            stack2.pop();
                        }else break;
                    }

                }
            }

        }

        StringBuilder sb=new StringBuilder();
        for(int n:reception)
            sb.append(n).append(" ");

        System.out.println(sb);
    }
}