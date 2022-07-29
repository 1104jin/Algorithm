import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20057 {

    static int[] sandAmount ={1,1,2,7,7,2,10,10,5};
    static int[][] mx = {{0,-1,1,-2,-1,1,2,-1,1,0},{1,-1,-1,0,0,0,0,1,1,2},
            {0,1,-1,2,1,-1,-2,1,-1,0},{-1,1,1,0,0,0,0,-1,-1,-2}};
    static int[][] my = {{-1,1,1,0,0,0,0,-1,-1,-2},{0,-1,1,-2,-1,1,2,-1,1,0},
            {1,-1,-1,0,0,0,0,1,1,2},{0,1,-1,2,1,-1,-2,1,-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader bd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int n = Integer.parseInt(bd.readLine());
        int[][] board = new int[n][n];

        for(int i = 0; i < n ; i ++){
            st = new StringTokenizer(bd.readLine());
            for(int j = 0; j < n;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //1. 회전
        //시작 n/2, n/2
        //2번씩하면서 1씩 증가
        //방향 4방향 진행
        int[] dx = {-1, 0, 1, 0 };
        int[] dy = {0, 1, 0, -1 };

        int turn = 0;
        int cnt = 0;
        int num = 1;

        int x = n/2;
        int y = n/2;
        int total = 0;

        while(x != 0 && y != 1){
            //먼저 이동
            //조건 확인

            if(cnt % 2 == 0){
                turn += 1;
                turn %= 4;
                cnt = 0;
                num++;
            }

            for(int i = 0; i < num ; i++){
                int nx = x + dx[turn];
                int ny = y + dy[turn];

                //이동한 장소에 모래 있는 지 확인
                if(board[nx][ny] == 0) continue;

                total += move(board, nx,ny, n, mx[turn], my[turn]);
                x = nx;
                y = ny;
                cnt++;
            }


        }

        System.out.println(total);

    }

    private static int move(int[][] board, int nx, int ny, int n, int[] dx, int[] dy) {
        //범위 내인지 아닌지 확인
        int sand = board[nx][ny];
        int sum = 0;

        for(int i = 1 ; i < 9 ; i++){
            int ax = nx + dx[i];
            int ay = ny + dy[i];
            int amount = (sand * sandAmount[i])/100;

            if(ax < 0 || ax >= n || ay < 0 || ay >= n){
                sum += amount;
            }else{
                board[ax][ay] += amount;
            }
        }

        //a
        int bx = nx + dx[0];
        int by = ny + dy[0];
        if(bx < 0 || bx >= n || by < 0 || by >= n) {
            sum += (sand * 55)/100;
        }else{
            board[bx][by] += (sand * 55)/100;
        }

        return sum;

    }


}
