import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        StringBuilder sb=new StringBuilder();

       
        HashMap<String,Integer> word=new HashMap<>();
        for(int i=0;i<N;i++){
            String input=bf.readLine();
            if(input.length()>=M){
                word.put(input,word.getOrDefault(input,0)+1);
            }
        }
        
        List<String> list=new ArrayList<>(word.keySet());
        list.sort((a,b)->{
                    int freA=word.get(a);
                    int freB=word.get(b);

                    if(freB!=freA) return freB-freA; //자주 나온 단어일수록 앞에 두기

                     if(a.length()!=b.length()) return b.length()-a.length(); //길이가 긴 단어일수록 앞에 두기

                    return a.compareTo(b); //알파벳 사전순 정렬
        }
        );
        
        for(String s:list){
            sb.append(s).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}