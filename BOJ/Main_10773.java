import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10773 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bd = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bd.readLine());
		Stack<Integer> total = new Stack<Integer>();
		
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(bd.readLine());
			if (a != 0) {
				total.push(a);
			} else {
				total.pop();
			}
		}
		int sum = 0;
		while(total.size()>0) {
			sum += total.pop();
		}
		System.out.println(sum);
	}
}
