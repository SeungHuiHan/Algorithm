import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int countSum=0;

        Map<String, Integer> map = new TreeMap<>();
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            if (line.isEmpty()) break;
            map.put(line, map.getOrDefault(line, 0) + 1);
            countSum++;
        }

        StringBuilder sb=new StringBuilder();

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            double ratio=(double)entry.getValue()/countSum*100;
            sb.append(entry.getKey()).append(" ").append(String.format("%.4f",ratio)).append("\n");
        }

        System.out.println(sb);
    }
}
