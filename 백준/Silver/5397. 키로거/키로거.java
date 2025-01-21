import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] agrs)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            List<Character> keyLogger=new LinkedList<>();
            String input=br.readLine();

            int index=0;
            for(int j=0;j<input.length();j++){
                char c=input.charAt(j);
                if(c=='<'){
                    index= Math.max(index - 1, 0);
                }else if(c=='>'){
                    index=Math.min(index + 1, keyLogger.size());
                }else if(c=='-'){
                    if(index>0){
                        keyLogger.remove(--index);
                        //index--;
                    }
                }else{
                    keyLogger.add(index,c);
                    index++;
                }
            }

            StringBuilder sb=new StringBuilder();
            for(char c1:keyLogger)
                sb.append(c1);

            System.out.println(sb);
        }
    }
}