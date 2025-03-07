import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        String s=sc.nextLine();
        
        
        int count=0;
        String n=s;
        while(n.length()>1){
            
            count++;
            int num=0;
            for(int i=0;i<n.length();i++){
                num+=n.charAt(i)-'0';
            }
            
            n=Integer.toString(num);
        }
        
        System.out.println(count);
        int num=Integer.parseInt(n);
        if(num==3 || num==6 || num ==9) System.out.println("YES");
        else System.out.println("NO");
    }
   
}