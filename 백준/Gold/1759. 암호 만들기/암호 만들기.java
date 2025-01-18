import java.util.*;

public class Main{
    private static int L,C;
    private static StringBuilder answer=new StringBuilder();
    private static char[] alpha;
    private static HashSet<Character> vowels=new HashSet<>();
    private static StringBuilder sb=new StringBuilder();

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);


        L=sc.nextInt();
        C=sc.nextInt();
        sc.nextLine();

        alpha=new char[C];

        String input=sc.nextLine();
        for(int i=0;i<input.length();i++){
            if(i%2==0)
                alpha[i/2]=input.charAt(i);
        }

        String s="aeiou";
        for(char c:s.toCharArray()){
            vowels.add(c);
        }

        Arrays.sort(alpha);

        backtracking(0,0);

        System.out.println(answer);
    }

    private static void backtracking(int start,int count){
        if(count==L){
            if(check(sb.toString())){
                answer.append(sb.toString()).append("\n");
                return;
            }
        }

        for(int i=start;i<C;i++){
            sb.append(alpha[i]);
            backtracking(i+1,count+1);
            sb.deleteCharAt(sb.length()-1);

        }
    }

    private static boolean check(String s){
        int vowelsCount=0;
        int consonantCount = 0;
        for(char c:s.toCharArray()){
            if(vowels.contains(c))
                vowelsCount++;
            else
                consonantCount++;
        }

        return vowelsCount>=1 && consonantCount>=2;
    }
}