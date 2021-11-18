import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576 {
	static int m, n;
	static int map[][];
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Queue<Integer> q = new LinkedList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader bd = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(bd.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bd.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					q.add(i);
					q.add(j);
				}
			}
		}

		bfs();
		int result = -2;
		boolean isfalse = false;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					isfalse = true;
				}
				result = Math.max(result, map[i][j]);
			}
		}

		if (isfalse) {
			System.out.println(-1);
		} else if (result == -1) {
			System.out.println(0);
		} else {
			System.out.println(result - 1);
		}
	}

	private static void bfs() {
		while (q.size() != 0) {
			int dx = q.poll();
			int dy = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = dx + dr[i];
				int ny = dy + dc[i];

				if (0 <= nx && nx < n && 0 <= ny && ny < m && map[nx][ny] == 0) {
					q.add(nx);
					q.add(ny);
					map[nx][ny] = map[dx][dy] + 1;
				}
			}
		}

	}

}
