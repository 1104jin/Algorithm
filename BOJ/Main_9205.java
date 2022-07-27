import java.util.Scanner;

public class Main_9205{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			int n = sc.nextInt();

			int[] x = new int[n + 2];
			int[] y = new int[n + 2];
			int[][] map = new int[n + 2][n + 2];

			for (int i = 0; i < n + 2; i++) {
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
			}

			for (int i = 0; i < n + 2; i++) {
				map[i][i] = 1; 
				for (int j = i + 1; j < n + 2; j++) {
					int d = Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]);
					if (d <= 1000)
						map[i][j] = map[j][i] = 1;
				}
			}

			for (int k = 0; k < n + 2; k++) {
				for (int i = 0; i < n + 2; i++) {
					for (int j = 0; j < n + 2; j++) {
						if (map[i][k] == 1 && map[k][j] == 1)
							map[i][j] = 1;
					}
				}
			}
			if(map[0][n+1] == 1)
				System.out.println("happy");
			else
				System.out.println("sad");
				
		}
	}
}
