import java.util.*;


public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);


        int N=sc.nextInt();
        HashSet<Integer> set=new HashSet();
        

        for(int i=0;i<N;i++){
            int a=sc.nextInt();
            set.add(a);
        }
       
        StringBuilder sb=new StringBuilder();
        
        int M=sc.nextInt();
       
        for(int i=0;i<M;i++){
            int b=sc.nextInt();
            if(set.contains(b)) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }


        System.out.println(sb);
    }
}