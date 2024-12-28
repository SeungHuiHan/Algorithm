import java.util.*;

public class Main{
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();


        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input.isEmpty()) break;
            list.add(Integer.parseInt(input));
        }

        for (int i = 0; i < list.size(); i++) {
            int n = list.get(i);
            long remainder = list.get(i); //나머지
            int length = 0;

            while (remainder != 0) {
                remainder = (remainder * 10 + 1) % n;
                length++;
            }

            System.out.println(length);

        }
        
    }
}