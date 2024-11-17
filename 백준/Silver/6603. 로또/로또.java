import java.util.*;

public class Main{
    private static ArrayList<int[]> testCase=new ArrayList<>();
    private static int[] arr;
    private static int[] numbers;
    private static StringBuilder sb;
    private static int N;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        sb=new StringBuilder();

        while(true){
            String[] intputStr=sc.nextLine().split(" ");
            int n=Integer.parseInt(intputStr[0]);
            if(n==0) break;

            int[] input=new int[n];
                for(int i=1;i< intputStr.length;i++){
                    input[i-1]=Integer.parseInt(intputStr[i]);
                }

                testCase.add(input);
        }

        for(int i=0;i<testCase.size();i++){
            arr=testCase.get(i).clone();
            N=arr.length;
            numbers=new int[6];
            backtracking(0,0);

            if(i!=testCase.size()-1)
                sb.append("\n");
        }


        System.out.println(sb.toString());


    }

    private static void backtracking(int start,int count){
        if(count==6){
            for(int n:numbers){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=start;i<N;i++){
            numbers[count]=arr[i];
            backtracking(i+1,count+1);
        }
    }
}