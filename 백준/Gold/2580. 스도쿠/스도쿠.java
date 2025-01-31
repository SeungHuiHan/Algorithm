import java.util.*;

public class Main{
    private static int[][] sudoku=new int[9][9];
    private static boolean solved;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                sudoku[i][j]=sc.nextInt();
            }
        }

        backtracking(0,0);

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                sb.append(sudoku[i][j]).append(" ");
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

        int nextRow=row;
        int nextCol=col;
        if(col==8){
            nextRow=row+1;
            nextCol=0;
        }else{
            nextCol=col+1;
        }

        if(sudoku[row][col]!=0) {
            backtracking(nextRow,nextCol);
            return;
        }

        for(int num=1;num<=9;num++){
            if(isValid(row,col,num)){
                sudoku[row][col]=num;
                backtracking(nextRow,nextCol);
                if(solved) return; //풀었으면 종료
                sudoku[row][col]=0;
            }
        }
    }

    private static boolean isValid(int row,int col,int num){
        for(int i=0;i<9;i++){
            if(sudoku[i][col]==num||sudoku[row][i]==num) return false;
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(sudoku[row-row%3+i][col-col%3+j]==num) return false;
            }
        }
        return true;
    }
}