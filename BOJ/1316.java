import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1316 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bd = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bd.readLine());

		int count = 0;
		for (int i = 0; i < n; i++) {

			char[] check = new char[26];
			char[] aa = bd.readLine().toCharArray();
			char c = aa[0];
			check[c - 97]++;
			boolean cc = true;

			for (int j = 1; j < aa.length; j++) {
				if (c == aa[j]) {
					check[aa[j] - 97]++;
					c = aa[j];
				} else {
					if (check[aa[j] - 97] < 1) {
						check[aa[j] - 97]++;
						c = aa[j];
					} else {
						cc = false;
						break;
					}
				}
			}
			if (cc) {
				count++;
			}
		}

		System.out.println(count);

	}

}
