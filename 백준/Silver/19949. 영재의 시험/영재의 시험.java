import java.util.*;

public class Main{
    private static int[] question=new int[10];
    private static int[] answer=new int[10];
    private static int answercount;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        for(int i=0;i<10;i++){
            question[i]=sc.nextInt();
        }
        backtracking(0,0,0);
        System.out.println(answercount);

    }

    private static void backtracking(int pre,int repeatCount,int count){
        if(count==10){
            int count5over=0;
            for(int i=0;i<10;i++){
                if(question[i]==answer[i])
                    count5over++;

            }

            if(count5over>=5) answercount++;
            return;
        }

        for(int i=1;i<=5;i++){

            if(pre==i && repeatCount==2) continue;

            answer[count]=i;
            backtracking(i,(pre==i)?repeatCount+1:1,count+1);
        }
    }
}