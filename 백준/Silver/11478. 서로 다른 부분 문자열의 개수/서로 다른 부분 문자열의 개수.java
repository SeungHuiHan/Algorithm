import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        HashSet<String> set=new HashSet<>();

        String s=sc.nextLine();

        for(int i=1;i<=s.length();i++){
            for(int j=0;j<s.length();j++){
                if(s.length()>=j+i) {
                    set.add(s.substring(j, j + i));
                }
            }
        }

        System.out.println(set.size());
    }
}