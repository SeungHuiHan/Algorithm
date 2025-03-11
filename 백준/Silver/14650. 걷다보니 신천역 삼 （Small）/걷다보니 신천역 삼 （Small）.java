import java.util.*;

public class Main{
    private static ArrayList<String> list=new ArrayList<>();
    private static int N;

    public static void main(String[] agrs){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        backtracking("",0);

        System.out.println(list.size());

    }

    private static void backtracking(String s,int count){
        if(count==N){
            int num=0;
            for(int i=0;i<s.length();i++){
                num+=s.charAt(i)-'0';
            }
            if(num%3==0) list.add(s);

            return;
        }
        for(int i=0;i<=2;i++){
            if(i==0&& s.equals("")) continue;
            else backtracking(s+i,count+1);
        }
    }
}