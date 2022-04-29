import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String arg[]) throws Exception {
		BufferedReader bd = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bd.readLine());

		int TestCase = Integer.parseInt(st.nextToken());
		for (int t = 1; t <= TestCase; t++) {
			st = new StringTokenizer(bd.readLine());

			int n = Integer.parseInt(st.nextToken());
			int[] marchandise = new int[n];
			st = new StringTokenizer(bd.readLine());
			for(int i = 0; i < n;i++) {
				marchandise[i] = Integer.parseInt(st.nextToken());
			}
			int max = 0;
			long total = 0;
			for (int i = n - 1; i >= 0; i--) {
				if (max < marchandise[i]) {
					max = marchandise[i];
				} else {

					int num = max - marchandise[i];
					total += num;

				}
			}
			System.out.println("#" + t + " " + total);
		}
	}
}
