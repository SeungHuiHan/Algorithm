import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] input=sc.nextLine().split("(?=[-+])|(?<=[-+])");

        int minusSum=0;
        int plusSum=0;

        boolean minus=false;

        for(int i=0;i<input.length;i++){

            if(input[i].equals("-") ){
                minus=true;
                continue;
            }if(input[i].equals("+") ){
                continue;
            }

            if(minus){
                minusSum+=Integer.parseInt(input[i]);
            }else{
                plusSum+=Integer.parseInt(input[i]);
            }
        }

        System.out.println(plusSum-minusSum);

    }
}