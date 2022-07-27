import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070 {
	static int N;
	static int[][] map;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bd = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(bd.readLine());

		map = new int[N + 1][N + 1];

		for (int i = 1; i < map.length; i++) {
			st = new StringTokenizer(bd.readLine());
			for (int j = 1; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken(" "));
			}
		}

		dfs(1, 2, 0, 1);
		System.out.println(cnt);
	}

	private static void dfs(int x, int y, int cx, int cy) {
		if (x == N && y == N) {
			cnt++;
			return;
		}

			if (cx == 1 && cy == 0) {
				if (check(x+1,y) && map[x + 1][y] == 0)
					dfs(x + 1, y, 1, 0);
				if (check(x+1,y+1) && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0 && map[x][y + 1] == 0)
					dfs(x + 1, y + 1, 1, 1);
			} else if (cx == 1 && cy == 1) {
				if (check(x+1,y) && map[x + 1][y] == 0)
					dfs(x + 1, y, 1, 0);
				if (check(x+1,y+1) && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0 && map[x][y + 1] == 0)
					dfs(x + 1, y + 1, 1, 1);
				if (check(x,y+1) && map[x][y + 1] == 0)
					dfs(x, y + 1, 0, 1);
			} else if (cx == 0 && cy == 1) {
				if (check(x+1,y+1) && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0 && map[x][y + 1] == 0)
					dfs(x + 1, y + 1, 1, 1);
				if (check(x,y+1) && map[x][y + 1] == 0)
					dfs(x, y + 1, 0, 1);
			}
		

	}
	
	private static boolean check(int x,int y) {
		if(-1 < x && x< N+1 && -1 < y && y < N+1) return true;
		return false;
		
	}

}
