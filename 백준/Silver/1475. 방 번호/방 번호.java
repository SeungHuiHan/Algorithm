import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        String input=sc.nextLine();

        int[] count=new int[10];

        for(int i=0;i<input.length();i++){
            int l=input.charAt(i)-'0';
            count[l]++;
        }

       count[6]=(count[6]+count[9]+1)/2;

        int maxSet=0;
        for(int i=0;i<9;i++){
            maxSet=Math.max(maxSet,count[i]);
        }

       // maxSet=Math.max(maxSet,count[9]);

        System.out.println(maxSet);
    }
}