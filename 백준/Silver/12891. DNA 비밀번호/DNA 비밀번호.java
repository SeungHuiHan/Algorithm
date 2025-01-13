import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int S=sc.nextInt();
        int P=sc.nextInt();
        sc.nextLine();

        String line=sc.nextLine();

        Map<Character,Integer> required=new HashMap<>();
        int Acount=sc.nextInt();
        int Ccount=sc.nextInt();
        int Gcount=sc.nextInt();
        int Tcount=sc.nextInt();

        required.put('A',Acount);
        required.put('C',Ccount);
        required.put('G',Gcount);
        required.put('T',Tcount);

        //-----------------

        Map<Character,Integer> current=new HashMap<>();
        current.put('A',0);
        current.put('C',0);
        current.put('G',0);
        current.put('T',0);

        for(int i=0;i<P;i++){
            char c=line.charAt(i);
            current.put(c,current.get(c)+1);
        }

        int count=0;
        if(isValid(current,required)){
            count++;
        }

        for(int i=P;i<S;i++){
            char addChar=line.charAt(i);
            current.put(addChar,current.get(addChar)+1);

            char removeChar=line.charAt(i-P);
            current.put(removeChar,current.get(removeChar)-1);


            if(isValid(current,required)){
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean isValid(Map<Character,Integer> current,Map<Character,Integer> required){
        for(char key:required.keySet()){
            if(current.get(key)<required.get(key)){
                return false;
            }
        }

        return true;
    }
 
}