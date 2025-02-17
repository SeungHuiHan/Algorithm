import java.util.*;

public class Main{
    private static int N;
    private static boolean found;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        
        backtracking(0,"");

    }

    private static void backtracking(int count,String s){
        if(found) return;
        if(count==N){

            System.out.println(s);
            found=true;
            return;
        }

        for(int i=1;i<=3;i++){
            if(check(s+i)){
                backtracking(count+1,s+i);
            }
        }
    }


    private static boolean check(String s){
        int len=s.length();

        for(int i=1;i<=len/2;i++){
            if(len-i*2>=0){
                if(s.substring(len-i*2,len-i).equals(s.substring(len-i,len))) return false;
            }else{
                break;
            }


        }

        return true;
    }
}