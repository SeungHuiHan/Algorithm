import java.util.*;


public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        
        int a=sc.nextInt();
        int b=sc.nextInt();
       
        int c=(a>b)?b:a;
        
        while(!((a%c==0) && (b%c==0))){
            c--;
        }


        
        System.out.println(c);
        System.out.println(c*(a/c)*(b/c));
        
    }
}