import java.util.*;
import java.lang.*;

class Solution {
    private static int max;
    private static boolean[][] visited;
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[m][n];
        max = 0;

        int[] answer = new int[2];

        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n ; j++){
                if(picture[i][j] != 0 && !visited[i][j]){
                    numberOfArea++;
                    dfs(i,j,picture,n,m);
                }
                if(max > maxSizeOfOneArea) maxSizeOfOneArea = max;
                max = 0;
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public int[] dx = {1,0,-1,0};
    public int[] dy = {0,-1,0,1};

    public void dfs(int x, int y, int[][] picture, int n,int m){
        visited[x][y] = true;
        max++;
        for(int i = 0; i < 4 ; i++){

            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= m || ny < 0 || ny >=n || visited[nx][ny]){
                continue;
            }
            if(picture[nx][ny] == picture[x][y] && !visited[nx][ny]){

                dfs(nx,ny,picture,n,m);
            }


        }

    }
}