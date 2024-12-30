import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int answer=0;

        int N=sc.nextInt();
        int M=sc.nextInt();
        sc.nextLine();

        String S=sc.nextLine();
        for(int i=0;i<=M-(2*N+1);i++){
            int count=0;
            for(int j=0;j<2*N+1;j++){
                if(j%2==0 && S.charAt(i+j)=='I') count++;
                else if(j%2==1 && S.charAt(i+j)=='O') count++;
                else break;
            }

            if(count==2*N+1) {
                answer++;
                i++;
            }
        }

        System.out.println(answer);

    }
}