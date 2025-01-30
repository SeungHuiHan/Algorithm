import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer=new StringBuilder();

        int T =Integer.parseInt(bf.readLine());

        for(int i=0;i<T;i++){
            String input=bf.readLine();

            int result = checkPalindromeType(input);
            answer.append(result).append("\n");

        }

        System.out.println(answer);
    }

    private static int checkPalindromeType(String s){
        int left=0; //왼쪽 인덱스
        int right=s.length()-1; //오른쪽 인덱스

        while(left<right){ //유사회문 검사
            if(s.charAt(left)!=s.charAt(right)){

                if(isPalindrome(s,left,right-1)||isPalindrome(s,left+1,right)){
                    return 1; //유사회문
                }else{
                    return 2; //회문 안됨
                }
            }

            left++;
            right--;
        }

        return 0; //회문

    }

    private static boolean isPalindrome(String s,int left,int right){
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}