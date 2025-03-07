import java.util.*;


public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] input=sc.nextLine().split(" ");
        String A=input[0];
        String B=input[1];
        
         
        int maxDifference=Integer.MAX_VALUE;
        for(int i=0;i<=B.length()-A.length();i++){
            int min=0;
            for(int j=0;j<A.length();j++){
                if(A.charAt(j)!=B.charAt(i+j)) min++;
                    
            }
            
            maxDifference=Math.min(maxDifference,min);
        }
        
        System.out.println(maxDifference);
        
        
    }
}