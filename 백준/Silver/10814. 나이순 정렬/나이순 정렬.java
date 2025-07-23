import java.util.*;


public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);


        int n=sc.nextInt();
        List<String[]> list=new ArrayList<>();

        for(int i=0;i<n;i++){

            String n1=sc.next();
            String n2=sc.next();
            list.add(new String[]{n1,n2,Integer.toString(i)});
        }

        list.sort((a,b)->{
            int compare=Integer.compare(Integer.parseInt(a[0]),Integer.parseInt(b[0]));
            if(compare!=0) return compare;
            else return Integer.compare(Integer.parseInt(a[2]),Integer.parseInt(b[2]));

        });

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(list.get(i)[0]+" "+list.get(i)[1]).append("\n");
        }



        System.out.println(sb);

    }
}