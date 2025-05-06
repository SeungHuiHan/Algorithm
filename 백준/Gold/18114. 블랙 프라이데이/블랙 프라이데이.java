import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int C=sc.nextInt();

        int[] boxes=new int[N];
        for(int i=0;i<N;i++){
            boxes[i]=sc.nextInt();
        }
        Arrays.sort(boxes);

        //한수로 끝남
        for(int i=0;i<N;i++) {
            if (boxes[i] == C) {
                System.out.println(1);
                return;
            }

        }
        //두수로 끝남
        int start=0;
        int end=N-1;
        while(start<end) {
            if (boxes[start] + boxes[end] == C) {
                System.out.println(1);
                return;
            } else if (boxes[start] + boxes[end] < C) {
                start++;
            } else {
                end--;
            }
        }


        //세 수

        for(int i=0;i<N-2;i++) {
            int sum=C-boxes[i];
            int left=i+1;
            int right=N-1;
            while(left<right) {
                if (boxes[left] + boxes[right] == sum) {
                    System.out.println(1);
                    return;
                }else if(boxes[left] + boxes[right] < sum) {
                    left++;
                }else{
                    right--;
                }

            }


        }

        System.out.println(0);

    }
}