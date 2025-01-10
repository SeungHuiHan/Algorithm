import java.util.*;

public class Main{
    public static void main(String[] agrs){
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int M=sc.nextInt();

        List<Integer> positive=new ArrayList<>();
        List<Integer> negative=new ArrayList<>();
        for(int i=0;i<N;i++){
            int input=sc.nextInt();
            if(input>0){
                positive.add(input);
            }else{
                negative.add(-input); //절대값으로 음수 저장
            }
        }

        Collections.sort(positive,Collections.reverseOrder()); //양수 내림차
        Collections.sort(negative,Collections.reverseOrder()); //음수 내림차(절대값으로)

        int positiveSum=0;
        for(int i=0;i<positive.size();i+=M){
            positiveSum+=2*positive.get(i);
        }

        int negativeSum=0;
        for(int i=0;i<negative.size();i+=M){
            negativeSum+=2*negative.get(i);
        }

        int totalSum=positiveSum+negativeSum;
        if(positive.isEmpty() && !negative.isEmpty()){ //마이너스 수가 없음
            totalSum-=negative.get(0); //음수 중 가장 큰 수
        }else  if(negative.isEmpty() && !positive.isEmpty()){
            totalSum-=positive.get(0);//양수 중 가장 큰 수
        }else if(!positive.isEmpty() && !negative.isEmpty()){
            totalSum-=Math.max(positive.get(0),negative.get(0)); //양수와 음수 중 가장 큰 수
        }

        System.out.println(totalSum);

    }
}