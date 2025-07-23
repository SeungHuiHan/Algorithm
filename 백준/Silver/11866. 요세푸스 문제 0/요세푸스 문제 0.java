import java.util.*;


public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);


        int N=sc.nextInt();
        int K=sc.nextInt();
        ArrayDeque<Integer> deque=new ArrayDeque<>();


        for(int i=1;i<=N;i++){
            deque.add(i);
        }


        StringBuilder sb=new StringBuilder();
        sb.append("<");

        int count=1;
        while(!deque.isEmpty()){
            if(count==K){
                sb.append(deque.poll()+", ");
                count=1;
            }else{

                int a=deque.poll();
                deque.add(a);

                count++;
            }

        }

        int len=sb.length();
        sb.delete(len-2,len);
        sb.append(">");



        System.out.println(sb);

    }
}