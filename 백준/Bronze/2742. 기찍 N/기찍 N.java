import java.util.*;


public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        
        int a=sc.nextInt();
        
        
        for(int i=a;i>=1;i--){
            sb.append(i).append("\n");
        }
        
        System.out.println(sb);
    }
}