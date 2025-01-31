import java.util.*;

public class Main{
    private static int[][] sudoku=new int[9][9];
    private static boolean solved=false;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        for(int i=0;i<9;i++){
            String[] str=sc.nextLine().split("");
            for(int j=0;j<9;j++){
                sudoku[i][j]=Integer.parseInt(str[j]);
            }
        }


        backtracking(0,0);

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                sb.append(sudoku[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);


    }

    private static void backtracking(int row,int col){
        if(row==9){
            solved=true;
            return;
        }

        //다음 위치
        int nextRow=row;
        int nextCol=col;
        if(col==8){
            nextRow=row+1;
            nextCol=0;
        }else{
            nextCol=col+1;
        }

        //현재 행,열이 0이 아니면 다음 칸이동
        if(sudoku[row][col]!=0) {
            backtracking(nextRow, nextCol);
            return;
        }

        for(int n=1;n<=9;n++){
            if(isValid(row,col,n)){
                sudoku[row][col]=n;
                backtracking(nextRow,nextCol);
                if(solved) return;
                sudoku[row][col]=0;
            }

        }


    }

    private static boolean isValid(int row,int col,int n){
        for(int i=0;i<9;i++){ // 같은 행,열에 같은 숫자가 있는지 확인
            if(sudoku[row][i]==n || sudoku[i][col]==n) return false;
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(sudoku[row-row%3+i][col-col%3+j]==n) return false;
            }
        }

        return true;
    }
}