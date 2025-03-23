import java.util.*;

public class Main{
    public static void main(String[] args){
       Scanner sc=new Scanner(System.in);
        HashMap<Integer,Integer> map=new HashMap<>();

        int N=sc.nextInt();
        for(int i=0;i<N;i++){
            int n=sc.nextInt();
            map.put(n,map.getOrDefault(n,0)+1);
        }


        int M=sc.nextInt();
        int[] answer=new int[M];
        for(int i=0;i<M;i++){
            int n=sc.nextInt();
            if(map.containsKey(n)){
                answer[i]=map.get(n);
            }else{
                answer[i]=0;
            }

        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<M;i++){
            sb.append(answer[i]+" ");
        }

        System.out.println(sb);
    }
}