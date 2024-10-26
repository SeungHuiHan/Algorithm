import java.util.*;

public class Main{
    private static int[][]map;
    private static List<int[]> chicken;
    private static List<int[]> homes;
    private static boolean[] chicken_flag;
    private static int min_distance=Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input=sc.nextLine().split(" ");
        int N=Integer.parseInt(input[0]);
        int M=Integer.parseInt(input[1]);
        map=new int[N][N];
        chicken=new ArrayList<>();
        homes=new ArrayList<>();


        for(int i=0;i<N;i++){
            input=sc.nextLine().split(" ");
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(input[j]);
                if(map[i][j]==1){
                    homes.add(new int[]{i,j});
                }
                if(map[i][j]==2){
                    chicken.add(new int[]{i,j});
                }
            }
        }

        chicken_flag=new boolean[chicken.size()];
        chickentracking(M,0,0);

        System.out.println(min_distance); //도시의 치킨거리
    }


    private static void chickentracking(int r,int start,int count){ //r: M개 조합, start: 시작 인덱스
        if(count==r){
            CityChickenDistance();
            return;
        }
        //M개 치킨집 조합 선택
        for(int i=start;i<chicken.size();i++){
            chicken_flag[i]=true; //치킨집 선택
            chickentracking(r,i+1,count+1); //다음 치킨집 선택
            chicken_flag[i]=false; //치킨집 취소
        }
    }

    //도시의 치킨거리 계산
    private static void CityChickenDistance(){
        int cityDistance=0; //치킨거리 합

        //각 집마다 가장 가까운 치킨집 거리 찾기
        for(int[] home:homes){
            int homeDistance=Integer.MAX_VALUE;

            for(int i=0;i<chicken.size();i++){
                if(chicken_flag[i]){
                    int[] chick=chicken.get(i);
                    int distance = Math.abs(home[0] - chick[0]) + Math.abs(home[1] - chick[1]);
                    homeDistance=Math.min(homeDistance,distance);//가장 가까운 치킨집 최소거리 갱신
                }
            }
            cityDistance+=homeDistance; //모든 집의 최고 치킨거리 합산
        }

        min_distance=Math.min(cityDistance,min_distance); //도시 치킨 거리 최소값 갱신

    }
}