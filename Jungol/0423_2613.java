import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class board {
		private int x;
		private int y;

		public board(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bd = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bd.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[m][n];

		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		Queue<board> queue = new LinkedList<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bd.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 1)
					queue.add(new board(i, j));
			}
		}
		int cnt = 1;

		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {

				board board = queue.poll();

				for (int z = 0; z < 4; z++) {
					int nx = board.x + dx[z];
					int ny = board.y + dy[z];

					if (nx < 0 || nx >= m || ny < 0 || ny >= n || map[nx][ny] != 0)
						continue;

					queue.add(new board(nx, ny));
					map[nx][ny] = cnt;
				}
			}

			if (!queue.isEmpty())
				cnt++;

		}
		boolean isTrue = true;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0) {
					isTrue = false;
					break;
				}
			}
		}

		System.out.println(isTrue ? cnt-1 : -1);

	}

}
