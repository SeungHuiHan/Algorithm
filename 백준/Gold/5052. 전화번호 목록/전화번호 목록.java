import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int T=sc.nextInt();

        for(int i=0;i<T;i++){
            int n=sc.nextInt();
            sc.nextLine();
            String[] num=new String[n];

            for(int j=0;j<n;j++){
                num[j]=sc.nextLine();
            }

            Arrays.sort(num);

            boolean t=false; //접두사인지
            for(int j=0;j<n-1;j++){
                if(num[j+1].startsWith(num[j])){
                    t=true;
                    break;
                }
            }

            System.out.println(t?"NO":"YES");
        
        }
    }
}
    