import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);


        int T=sc.nextInt();
        sc.nextLine();

        for(int i=0;i<T;i++){
            ArrayList<Integer> list=new ArrayList<>();
            int N=Integer.parseInt(sc.nextLine());
            String[] s=sc.nextLine().split(" ");

            for(int j=0;j<s.length;j++){
                list.add(Integer.parseInt(s[j]));
            }
            Collections.sort(list);

            int MaxDifference=list.get(list.size()-1)-list.get(list.size()-2);
            //System.out.println("첫번째: "+MaxDifference);

            for(int j=0;j<list.size()-2;j++){
                if(list.get(j+2)-list.get(j)>MaxDifference){
                    MaxDifference=list.get(j+2)-list.get(j);
                }
            }

            System.out.println(MaxDifference);
        }
    }
}