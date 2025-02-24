import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        long S=sc.nextInt();
        long M=sc.nextInt();

       if(S<1024){
            System.out.println( "No thanks");
        }else if(((S-1023)&M)==(S-1023)) System.out.println("Thanks" );
        else System.out.println("Impossible" );
    }
}