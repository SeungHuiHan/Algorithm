import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        String S=sc.nextLine();
        String B=sc.nextLine();
        StringBuilder sb=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        int bombLength=B.length();
        
        
        for(int i=0;i<S.length();i++){
            sb.append(S.charAt(i));
            
            if(sb.length()>=bombLength){
                sb2.append(sb.substring(sb.length()-bombLength,sb.length()));
                if(sb2.toString().equals(B)){
                    sb.setLength(sb.length()-bombLength);
                }
                sb2.setLength(0);
            } 
        }
        
        if(sb.length()==0){
            System.out.println("FRULA");
        }else{
            System.out.println(sb.toString());
        }
    }
}