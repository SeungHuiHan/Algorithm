import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        HashSet<Integer> hash=new HashSet<>();

        int N=sc.nextInt();
        for(int i=0;i<N;i++){
            int n=sc.nextInt();
            hash.add(n);
        }
        StringBuilder sb=new StringBuilder();

        int M=sc.nextInt();
        for(int i=0;i<M;i++){
            int n=sc.nextInt();
            if(hash.contains(n)) sb.append(1);
            else sb.append(0);
            sb.append("\n");
        }

        sb.deleteCharAt(sb.length()-1);

        System.out.println(sb);
    }
}