import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        long vowel=(1<<('a'-'a'))|(1<<('e'-'a'))|(1<<('i'-'a'))
                |(1<<('o'-'a'))|(1<<('u'-'a')); //모음은 잊어버리지 않음

        int N=sc.nextInt();
        int M=sc.nextInt();
        sc.nextLine();

        long[] wordBits=new long[N];
        long rememberedBit= (1 << 26) - 1; // 모든 알파벳을 기억하는 상태

        for(int i=0;i<N;i++){
            String s=sc.nextLine();
            long bitmask=0;

            for(int j=0;j<s.length();j++){
                char c =s.charAt(j);
                bitmask |=(1L<<(c-'a'));
            }

            wordBits[i]=bitmask;
        }

        StringBuilder answer=new StringBuilder();
        for(int i=0;i<M;i++){
            String[] s=sc.nextLine().split(" ");
            int op=Integer.parseInt(s[0]);
            char ch=s[1].charAt(0);

            if(op==1){ // 알파벳 잊음
                rememberedBit &= ~(1L<<(ch-'a'));
            }else if(op==2){ // 알파벳 기억해냄
                rememberedBit |= (1L<<(ch-'a'));
            }

            int count=0;
            for(long wordBit: wordBits){
                if((wordBit & rememberedBit)==wordBit) count++; //기억해낸 문자열 카운트
            }
            answer.append(count).append("\n");
        }

        System.out.println(answer);

    }

}