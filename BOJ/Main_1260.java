import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
	static int n , m, v;
	static int[][] map;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();
		
		map = new int[n+1][n+1];
		visited = new boolean[n+1];
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			map[a][b] =map[b][a] = 1;
		}
		
		dfs(v);
		System.out.println();
		visited = new boolean[n+1];
		bfs(v);
	}

	private static void bfs(int v2) {
		Queue<Integer> q = new LinkedList<Integer>();
		visited[v2] = true;
		q.offer(v2);
		
		while(!q.isEmpty()) {
			int a = q.poll();
			System.out.print(a+" ");
			
			for (int i = 1; i < n+1; i++) {
				if(map[a][i] == 1 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
		
	}

	private static void dfs(int a) {
		System.out.print(a + " ");
		visited[a] = true;
		
		for (int i = 1; i < n+1; i++) {
			if(map[a][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
		
	}

}
