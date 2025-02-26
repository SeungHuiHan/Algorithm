import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> list=new ArrayList<>();

        StringBuilder sb=new StringBuilder();

        int T=sc.nextInt();
        list.add(0);
        list.add(1);
        while(list.get(list.size()-1)<1000000000){
            int n=list.get(list.size()-2)+list.get(list.size()-1);
            list.add(n);
        }

        for(int i=0;i<T;i++){
            int n=sc.nextInt();
            ArrayList<Integer> result=new ArrayList<>();


            int index=0;
            while(list.get(index)<n){
                index++;
            }
           


            for(int j=index;j>=0;j--){
                if(n==0) break;
                else if(list.get(j)<=n){
                    result.add(list.get(j));

                    n-=list.get(j);
                }


            }
            Collections.sort(result);
            for(int re:result){
                sb.append(re+" ");
            }
            sb.append("\n");


        }

        System.out.println(sb);

    }
}