import java.util.*;

public class Main{
    private static int n,k;
    private static int[] a;
    private static HashSet<String> set=new HashSet<>();
    private static boolean[] visited;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        n=sc.nextInt();
        k=sc.nextInt();
        a=new int[n];
        visited=new boolean[n];

        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }

        backtracking(0,"");
        System.out.println(set.size());
    }

    private static void backtracking(int count,String s){
        if(count==k){
            if(!set.contains(s)){
                //System.out.println(s);
                set.add(s);
            }
            return;
        }

        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i]=true;
                backtracking(count+1,s+a[i]);
                visited[i]=false;
            }

        }


    }
}