import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1457 {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader bd = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bd.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int k = Integer.parseInt(st.nextToken());
		map = new int[m][n];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(bd.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int startX = x; startX < x2; startX++) {
				for (int startY = y; startY < y2; startY++) {
					map[startY][startX] = 1;
				}
			}

		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		cnt = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0) {
					cnt = 0;
					dfs(i, j);
					result.add(cnt);

				}
			}
		}

		Collections.sort(result);
		System.out.println(result.size());
		for (int total : result)
			System.out.print(total + " ");
		System.out.println();
	}

	private static void dfs(int x, int y) {
		cnt++;
		map[x][y] = 1;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length || map[nx][ny] != 0)
				continue;

			dfs(nx, ny);
		}

	}

}
