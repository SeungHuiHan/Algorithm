import java.util.*;
public class Main{
   private static ArrayDeque<Node> queue;
    private static int[][] map;
    private static boolean[][] visited;
    private static List<int[]> union;

    private static int N;
    private static int below;
    private static int above;
    private static int count;
    private static int sum;
    private static int total_count;


    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static class Node{
        int r,c;
        public Node(int r,int c){
            this.r=r;
            this.c=c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input=sc.nextLine().split(" ");
        N=Integer.parseInt(input[0]);

        below=Integer.parseInt(input[1]);
        above=Integer.parseInt(input[2]);
        map=new int[N][N];


        for(int i=0;i<N;i++){
            input=sc.nextLine().split(" ");
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(input[j]);
            }
        }

        queue=new ArrayDeque<>();
        while (true){
            boolean isMoved=false;
            visited=new boolean[N][N];

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){

                    if(!visited[i][j]){
                        union=new ArrayList<>();
                        sum=0;
                        count=0;


                        if(bfs(i,j)){ //연합 생김
                            isMoved=true;
                            sameproporty(); //인구이동
                        }

                    }
                }
            }

            if(!isMoved)
                break;
            total_count++;
        }


        System.out.println(total_count);

    }

    //bfs 너비우선탐색
    private static boolean bfs(int r,int c){
        queue.offer(new Node(r, c));
        visited[r][c]=true;

        while(!queue.isEmpty()){
            Node now=queue.poll();
            sum+=map[now.r][now.c];
            count++;
            union.add(new int[]{now.r,now.c});

            for(int i=0;i<4;i++){
                int nr=now.r+dx[i];
                int nc=now.c+dy[i];

                if(nr<0||nr>=N||nc<0||nc>=N ||visited[nr][nc]) continue;

                int diff = Math.abs(map[now.r][now.c] - map[nr][nc]); //인접한 좌표 값 차이
                if(diff>=below && diff<=above) { //주어진 이상, 이하의 값을 만족할때
                    visited[nr][nc]=true;
                    queue.offer(new Node(nr,nc));

                }

            }
        }
        return count>1;
    }

    private static void sameproporty(){
        int average=sum/count; //인접한 나라 값 평균 인구
        for(int[] pos:union){
            map[pos[0]][pos[1]]=average;
        }

    } 
}