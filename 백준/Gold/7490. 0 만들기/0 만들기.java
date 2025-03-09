import java.util.*;

public class Main{
    private static int N;
    private static StringBuilder sb=new StringBuilder();
    private static ArrayList<String> list=new ArrayList<>();
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int T=sc.nextInt();

        for(int i=0;i<T;i++){
            N=sc.nextInt();

            backtracking(1,"1",1,list);

            Collections.sort(list);
            
            for(int j=0;j<list.size();j++){
                sb.append(list.get(j));
                sb.append("\n");
            }
            
            if(i!=T-1)
                sb.append("\n");
            list.clear();
           


        }

        System.out.println(sb);
    }


    private static void backtracking(int start, String target, int count, List<String> list){
        if(count==N){
            if(check(target)){
                list.add(target);
            }
           return;
        }

        backtracking(start+1,target+"+"+(start+1),count+1,list);
        backtracking(start+1,target+"-"+(start+1),count+1,list);
        backtracking(start+1,target+" "+(start+1),count+1,list);

    }

    private static boolean check(String target){
        String newTarget=target.replace(" ","");
        String[] token=newTarget.split("(?=[+-])");
        int sum=Integer.parseInt(token[0]);

        for(int i=1;i<token.length;i++){
            sum+=Integer.parseInt(token[i]);
        }


        return sum == 0;
    }
}