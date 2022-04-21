import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
	static int n, m, r, c, l;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] d = { { 1, 2, 5, 6 }, { 1, 3, 6, 7 }, { 1, 2, 4, 7 }, { 1, 3, 4, 5 } };
	static int[][] locate = { {}, { 0, 1, 2, 3 }, { 0, 2 }, { 1, 3 }, { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } };

	public static void main(String arg[]) throws Exception {
		BufferedReader bd = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int testCase = Integer.parseInt(bd.readLine());
		for (int t = 1; t <= testCase; t++) {
			st = new StringTokenizer(bd.readLine());

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());

			map = new int[n][m];
			visited = new boolean[n][m];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bd.readLine());
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			visited[r][c] = true;
			System.out.println("#"+t+" "+bfs(r, c));
		}

	}

	private static int bfs(int r, int c) {
		Queue<Integer> queueX = new LinkedList<>();
		Queue<Integer> queueY = new LinkedList<>();

		queueX.add(r);
		queueY.add(c);

		int count = 0;
		int temp = 1;

		while (!queueX.isEmpty()) {
			if (temp > l)
				break;
			int size = queueX.size();
			for (int s = 0; s < size; s++) {
				int x = queueX.poll();
				int y = queueY.poll();
				count++;
				
				int z = map[x][y];
				// 가야할 방향 지정
				int[] lo = locate[z];

				for (int i = 0; i < lo.length; i++) {
					// 이동할 수 있는지 확인
					int nx = x + dx[lo[i]];
					int ny = y + dy[lo[i]];

					if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || map[nx][ny] == 0)
						continue;

					int check = 0;
					for (int j : d[lo[i]]) {
						if (j == map[nx][ny])
							check++;
					}

					if (check == 0)
						continue;

					queueX.add(nx);
					queueY.add(ny);
					visited[nx][ny] = true;
					
				}
			}
			temp++;

		}

		return count;
	}

}
