import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int answer=0;

        int N=sc.nextInt();
        int M=sc.nextInt();
        sc.nextLine();

        String S=sc.nextLine();
        int count=0;
        for(int i=0;i<M-2;i++){

            if(S.charAt(i)=='I' && S.charAt(i+1)=='O' && S.charAt(i+2)=='I'){
                count++;
                i++;
                if(count==N){
                    answer++;
                    count--;
                }
            }else{
                count=0;
            }


        }

        System.out.println(answer);

    }
}