import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();

        int N1=(~N)+1;

        System.out.println(Integer.bitCount(N^N1));
    }
}