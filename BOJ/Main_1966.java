package self.BJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1966 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			Queue<int[]> q = new LinkedList<int[]>();
			for (int i = 0; i < n; i++) {
				int a = sc.nextInt();
				q.add(new int[] {i,a});
			}
			
			int x,y, count = 0;
			
			while(true) {
				boolean isTrue = true;
				int b[] = q.poll();
				x = b[0];
				y = b[1];
				
				//뒤에 나보다 큰 값없으면 출력
				for (int i = 0; i < q.size(); i++) {
					int[] temp= q.poll();
					if(y<temp[1]) {
						isTrue = false;
					}

					q.add(temp);
				}
				
				if(isTrue) {
					count++;
					if(x == m) {
						System.out.println(count);
						break;
					}
				}else {
					q.offer(new int[] {x,y});
				}
			}
		}

	}

}
