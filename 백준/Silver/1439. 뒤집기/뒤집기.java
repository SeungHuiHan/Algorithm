import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        String input=sc.nextLine();
        int oneCount=0;
        int zeroCount=0;

        char prev=input.charAt(0);
        if(prev=='0') zeroCount++;
        else oneCount++;

        for(int i=1;i<input.length();i++){
            char c=input.charAt(i);
            if(c!=prev){
                if(c=='0') zeroCount++;
                else oneCount++;
                prev=c;
            }
        }

        System.out.println(Math.min(zeroCount,oneCount));
    }
}