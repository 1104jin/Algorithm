import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class code_4485 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int cnt = 1;
		int[] dr= {0,0,1,-1};
		int[] dc= {1,-1,0,0};

		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) break;
			
			int[][] map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] distance = new int[n][n];
			
			for (int i = 0; i < n; i++) {
				Arrays.fill(distance[i], Integer.MAX_VALUE);
			}
			
			distance[0][0] = map[0][0];
			
			PriorityQueue<Edge> q = new PriorityQueue<>();
			q.add(new Edge(0,0,distance[0][0]));
			
			while(!q.isEmpty()) {
				Edge e = q.poll();
				
				for (int i = 0; i < 4; i++) {
					int nx = e.start + dr[i];
					int ny = e.end + dc[i];
					
					if(-1 < nx && nx < n && -1 < ny && ny < n) {
						if(distance[nx][ny] > distance[e.start][e.end] + map[nx][ny]) {
							distance[nx][ny] = distance[e.start][e.end] + map[nx][ny];
							q.add(new Edge(nx,ny,distance[nx][ny]));
						}
					}
				}
			}
			
			System.out.printf("Problem %d: %d%n",cnt,distance[n-1][n-1]);
			cnt++;
		}
	
	}

	private static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int distance;
		
		public Edge(int start, int end, int distance) {
			super();
			this.start  = start;
			this.end = end;
			this.distance = distance;
		}
		
		public int compareTo(Edge o) {
			return distance - o.distance;
		}
		
		
	}
}
