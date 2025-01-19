import java.util.*;

public class Main {
    private static char[][] maps;
    private static List<int []> emptySpace=new ArrayList<>();
    private static int[] dx={0,0,-1,1};
    private static int[] dy={-1,1,0,0};
    private static boolean unfound;
    private static int N;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        sc.nextLine();

        maps=new char[N][N];

        for(int i=0;i<N;i++){
            String[] input=sc.nextLine().split(" ");
            for(int j=0;j<N;j++){
                maps[i][j]=input[j].charAt(0);
                if(maps[i][j]=='X')
                    emptySpace.add(new int[]{i,j});
            }
        }

        backtracking(0,0,new int[3][]);

        System.out.println(unfound?"YES":"NO");
    }

    private static void backtracking(int start,int count,int[][] selected){
        if (unfound) return;
        if(count==3){
            if(checkingObstacles(selected)){ //학생 발견하지 못하면
                unfound=true;
                return;
            }
            return;
        }

        for(int i=start;i<emptySpace.size();i++){
            selected[count]=emptySpace.get(i);
            backtracking(i+1,count+1,selected);
        }

    }

    //장애물로 막아지는지 확인
    private static boolean checkingObstacles(int[][] selected){
        for(int[] s:selected){
            maps[s[0]][s[1]]='O';
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(maps[i][j]=='T'){
                    if(watch(i,j)){ 
                         // 장애물 제거
                        for(int[] s : selected){
                            maps[s[0]][s[1]] = 'X';
                        }
                        return false;
                    } //학생 먼저 발견
                }
            }
        }

        //장애물 제거
        for(int[] s:selected){
            maps[s[0]][s[1]]='X';
        }

        return true; //학생 발견하지 못함
    }

    // 장애물 확인: true면 학생을 발견, false면 발견하지 못함
    private static boolean watch(int x, int y){
       for(int i=0;i<4;i++){
           int nx=x;
           int ny=y;

           while(true){
               nx+=dx[i];
               ny+=dy[i];

               if(nx<0 || nx>=N || ny<0 || ny>=N) break;
               if(maps[nx][ny]=='O') break;
               else if(maps[nx][ny]=='S') return true;
           }
       }
       return false;
    }
}
