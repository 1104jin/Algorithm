import java.util.Arrays;
import java.util.Scanner;

public class Main_2961 {
	private static int N, input[][], totalCnt, sum, sNum, bNum;
	static boolean[] isSelected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N][2];
		isSelected = new boolean[N];
		totalCnt = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			input[i][0] = sc.nextInt();
			input[i][1] = sc.nextInt();
		}

		generateSubset(0);
		System.out.println(totalCnt);
	}

	private static void generateSubset(int cnt) {
		if (cnt == N) {
			int  count = 0;
			sum = 0;
			sNum = 1;
			bNum = 0;
			
			for (int i = 0; i < N; i++) {
				// System.out.print((isSelected[i]);
				if (isSelected[i]) {
					sNum *= input[i][0];
					bNum += input[i][1];
					sum = Math.abs(sNum - bNum);
					count++;
				}

			}
			if(count == 0) return;
			totalCnt = Math.min(totalCnt, sum);
			return;
		}
		// 현재원소 부분집합에 넣기
		isSelected[cnt] = true;
		generateSubset(cnt + 1);

		// 현재원소 부분집합에 넣지 않기
		isSelected[cnt] = false;
		generateSubset(cnt + 1);
	}

}
