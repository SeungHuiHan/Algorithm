import java.util.*;


public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();

        int n=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            String s=sc.nextLine();
            int sum=0;
            int count=0;

            for(int j=0;j<s.length();j++){
                char d=s.charAt(j);
                if(d=='O'){
                    count++;
                    sum+=count;
                }else{
                    count=0;
                }
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}