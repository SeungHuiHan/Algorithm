import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        Map<Character,Integer> weight=new HashMap<>();

        int N=Integer.parseInt(bf.readLine());
        String[] words=new String[N];
        for(int i=0;i<N;i++){
            words[i]=bf.readLine();

            int power=1;
            for(int j=words[i].length()-1;j>=0;j--){
                char c=words[i].charAt(j);

                weight.put(c,weight.getOrDefault(c,0)+power);
                power*=10;
            }
        }

        List<Map.Entry<Character,Integer>> sortedWeight=new ArrayList<>(weight.entrySet());
        sortedWeight.sort((a,b)->(b.getValue()-a.getValue()));


        Map<Character,Integer> charToNum=new HashMap<>();
        int n=9;
        for(Map.Entry<Character,Integer> entry:sortedWeight){
            charToNum.put(entry.getKey(),n--);
        }



        int totalSum=0;
        for(int i=0;i<N;i++){
            String s=words[i];
            int sum=0;

            for(int j=0;j<s.length();j++){
                char c=s.charAt(j);
                sum=10*sum+charToNum.get(c);
            }

            totalSum+=sum;
        }

        System.out.println(totalSum);

    }
}