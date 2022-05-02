import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
	static int n, total = Integer.MIN_VALUE;
	static char[] board;
	static int[] place = new int[2];

	public static void main(String arg[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		
		board = sc.next().toCharArray();
		System.out.println((int)'0');
		calcul(0, 0);
		conv(0, 0);
		
		System.out.println(total);

	}

	private static void conv(int cnt, int start) {
		if (cnt == 2) {
			// 계산
			calcul(place[0], place[1]);
			return;
		}

		for (int i = start; i < n + 2; i++) {
			if (cnt == 0 || place[0] > start - 4)
				continue;

			place[cnt] = i;
			conv(cnt + 1, i + 1);
		}

	}

	private static void calcul(int i, int j) {
		Stack<Character> stack = new Stack<>();
		int sum = 0;
		
		if (i == j) {
			for (int num = n-1;num>=0;num--) {
				stack.add(board[num]);
			}

			while (stack.size() != 1) {
				int n1 = stack.pop() - '0';
				char method = stack.pop();
				int n2 = stack.pop() - '0';
				sum = 0;
				// 계산
				if (method == '+') {
					sum = (n1 + n2);
				} else if (method == '*') {
					sum = (n1 * n2);
				} else {
					sum = n1 - n2;
				}

				stack.add((char) sum);
			}

		} else {
			StringBuilder sb = new StringBuilder();
			for (int num = n-1;num>=0;num--) {
				if (num == i)
					stack.add('(');
				else if (num == j)
					stack.add(')');

				stack.add(board[num]);
			}

			for (int a = 0; a < i; a++) {
				sb.append(stack.pop());
			}

			while (stack.size() != 1) {

				if (stack.peek() == '(' || stack.peek() == ')') {
					stack.pop();
				}

				int n1 = stack.pop() - '0';
				char method = stack.pop();
				int n2 = stack.pop() - '0';
				sum = 0;
				
				// 계산
				if (method == '+') {
					sum = (n1 + n2);
				} else if (method == '*') {
					sum = (n1 * n2);
				} else {
					sum = n1 - n2;
				}

				stack.add((char) sum);

			}

		}
		
		total = Integer.max(total, sum);

	}

}
