import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int n, m, total = Integer.MIN_VALUE;
	static int[][] map, remap;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	static class mape {
		int x;
		int y;
		public mape(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	
	}
	public static void main(String arg[]) throws Exception {
		BufferedReader bd = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bd.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		remap = new int[n][m];
		
		for(int i = 0; i < n;i++) {
			st = new StringTokenizer(bd.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		remap = map;
		
		Dfs(0);
		System.out.println(total);

	}

	private static void Dfs(int cnt) {
		if(cnt == 3) {
			total = Integer.max(total, Bfs());
			return;
		}
		
		for(int i = 0; i < n ; i++) {
			for(int j = 0; j < m ; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					Dfs(cnt + 1);
					map[i][j] = 0;
				}
					
			}
		}
		
	}

	private static int Bfs() {
		int count = 0;
		Queue<mape> queue = new LinkedList<>();
		int[][] vmap = new int[n][m];
		
		for(int i = 0; i < n ; i++) {
			for(int j = 0; j < m ; j++) {
				vmap[i][j] = map[i][j];
				if(map[i][j] == 2)
					queue.add(new mape(i,j));
			}
		}
		
		while(!queue.isEmpty()) {
			 mape mapee = queue.poll();
			 
			 for(int i = 0 ; i < 4 ; i++) {
				 int nx = mapee.x + dx[i];
				 int ny = mapee.y + dy[i];
			 
			 if(nx < 0 || nx >= n || ny < 0 || ny >= m ) 
				 continue;
			 if(vmap[nx][ny] == 0) {
				 vmap[nx][ny] = 2;
				 queue.add(new mape(nx,ny));
			 }
			 }
			
		}
		
		for(int i = 0; i < n ; i++) {
			for(int j = 0; j < m ; j++) {
			if(vmap[i][j] == 0)
				count++;
			}
		}
		
		return count;
		
		
	}

	

}
