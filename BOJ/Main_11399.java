import java.util.Arrays;
import java.util.Scanner;

public class Main_11399 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] map = new int[N+1];

		for (int i = 1; i < N+1; i++) {
			map[i] = sc.nextInt();
		}
		
		Arrays.sort(map);
		int total = 0;
		for (int i = 1; i < map.length; i++) {
			total += (map[i]*(N-i+1));
		}
		
		System.out.println(total);
	}

}
