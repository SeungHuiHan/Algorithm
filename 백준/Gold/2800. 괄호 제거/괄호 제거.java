import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Stack<Integer> stack=new Stack<>();
        Set<String> resultSet = new HashSet<>(); 

        String line=sc.nextLine();

        List<int[]> pair=new ArrayList<>(); //괄호 쌍 인덱스
        for(int i=0;i<line.length();i++){
            char c=line.charAt(i);
            if(c=='('){
                stack.push(i);
            }else if(c==')'){
                pair.add(new int[]{stack.pop(),i});
            }
        }

        int N=pair.size(); //괄호 쌍 크기

        for(int mask=1;mask<(1<<N);mask++){
            Set<Integer> toRemove=new HashSet<>();
            for(int i=0;i<N;i++){
                if((mask & (1<<i))!=0){
                    toRemove.add(pair.get(i)[0]);
                    toRemove.add(pair.get(i)[1]);
                }
            }

            StringBuilder sb=new StringBuilder();
            for(int i=0;i<line.length();i++){
                if(!toRemove.contains(i)){
                    sb.append(line.charAt(i));
                }
            }

            resultSet.add(sb.toString());
        }
        
        List<String> result=new ArrayList<>(resultSet);
        Collections.sort(result);
        
        for(String s:result)
            System.out.println(s);
        
    }
}