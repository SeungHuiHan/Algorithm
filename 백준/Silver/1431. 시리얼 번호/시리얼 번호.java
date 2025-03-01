import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        sc.nextLine();
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<N;i++){
            list.add(sc.nextLine());
        }

        list.sort(
                (a,b)->{
                    if(a.length()!=b.length()) return Integer.compare(a.length(),b.length());
                    else if(a.length()==b.length()){
                        int aNum=0;
                        int bNum=0;

                        for(char aChar:a.toCharArray()){
                            if(Character.isDigit(aChar)){
                                aNum+=aChar-'0';
                            }
                        }

                        for(char bChar:b.toCharArray()){
                            if(Character.isDigit(bChar)){
                                bNum+=bChar-'0';
                            }
                        }

                        if(aNum!=bNum){
                            return Integer.compare(aNum,bNum);
                        }
                    }
                    return a.compareTo(b);

                }
        );




        StringBuilder sb=new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(list.get(i));
            sb.append("\n");
        }

        System.out.println(sb);
    }
}