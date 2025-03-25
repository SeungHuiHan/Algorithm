import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int m=sc.nextInt();

        HashSet<Integer> nset=new HashSet<>();
        HashSet<Integer> mset=new HashSet<>();

        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            nset.add(a);
        }
        for(int i=0;i<m;i++){
            int a=sc.nextInt();
            mset.add(a);
        }

        int total=0;
        Iterator<Integer> niterator=nset.iterator();


        for(int i=0;i<n;i++){
            int a=niterator.next();
            if(!mset.contains(a)) total++;
        }

        Iterator<Integer> miterator=mset.iterator();


        for(int i=0;i<m;i++){
            int a=miterator.next();
            if(!nset.contains(a)) total++;
        }

        System.out.println(total);
    }
}