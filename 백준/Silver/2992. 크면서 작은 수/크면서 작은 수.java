import java.util.*;

public class Main{
    private static ArrayList<Integer> list=new ArrayList<>();
    private static char[] c;
    private static int n;
    private static boolean[] visited;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        c=Integer.toString(n).toCharArray();
        visited=new boolean[c.length];

        backtracking("",0);
        Collections.sort(list);
        System.out.println(list.isEmpty()?0:list.get(0));
    }

    private static void backtracking(String s,int count){
        if(count==c.length){
            if(n<Integer.parseInt(s)){
                list.add(Integer.parseInt(s));
            }
            return;
        }

        for(int i=0;i<c.length;i++){
            if(!visited[i]){
                visited[i]=true;
                backtracking(s+c[i],count+1);
                visited[i]=false;
            }

        }
    }
   
}