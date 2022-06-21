import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testcase = sc.nextInt();

		for (int t = 1; t < testcase + 1; t++) {
			// 메모리값 받기
			String temp = sc.next();
			int count = 0;

			// 값을 배열에 넣어준다.
			char[] a = temp.toCharArray();

			// 비교할 배열을 생성
			char[] b = new char[temp.length()];

			// b배열은 0으로 저장
			Arrays.fill(b, '0');

			// 비교
			for (int i = 0; i < a.length; i++) {
				if (a[i] != b[i]) {
					count++;
					for (int j = i; j < a.length; j++) {
						b[j] = a[i];
					}
				}
			}

			System.out.println("#" + t + " " + count);

		}

	}

}
