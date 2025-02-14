import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        Stack<Integer> stack=new Stack<>();

        int N=sc.nextInt();
        int K=sc.nextInt();
        sc.nextLine();


        String[] input=sc.nextLine().split("");
        int count=0;
        for(int i=0;i<N;i++){
            int a=Integer.parseInt(input[i]);

            if(count<K){
                if(stack.isEmpty()){
                    stack.push(a);
                }
                else{
                    int len=stack.size();
                    for(int j=0;j<len;j++){
                        if(count<K && stack.peek()<a){
                            stack.pop();
                            count++;
                        }else break;
                    }
                    stack.push(a);

                }
            }else{
                stack.push(a);
            }

        }

        for(int i=0;i<N-K;i++){
            sb.append(stack.get(i));
        }

        System.out.println(sb);

    }
}