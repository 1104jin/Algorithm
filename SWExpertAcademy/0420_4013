import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
	static int[][] wheel;
	static int[] visited;

	public static class turnV {
		private int turn;
		private int value;

		public turnV(int turn, int value) {
			super();
			this.turn = turn;
			this.value = value;
		}

		public int getTurn() {
			return turn;
		}

		public void setTurn(int turn) {
			this.turn = turn;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

	}

	public static void main(String arg[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());

			int k = Integer.parseInt(st.nextToken());
			wheel = new int[4][8];
			visited = new int[4];

			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					wheel[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ArrayList<turnV> turn = new ArrayList<>();
			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				turn.add(new turnV(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())));
			}

			// 계산시작
			for (int i = 0; i < k; i++) {
				// 시작 바퀴와 회전 방향 받기
				int start = turn.get(i).getTurn();
				int un = turn.get(i).getValue();

				// 시계방향이면 1, 아니면 -1, 회전안하면 0
				visited[start] = un;

				// -1하면서 값 비교
				for (int j = start - 1; j > -1; j--) {
					// 기존의 바퀴의 값과 같은지 비교
					if (wheel[start][6] != wheel[j][2]) {
						visited[j] = visited[start] * -1;
					}else {
						break;
					}
					start = j;

				}

				// 1하면서 값 비교

				start = turn.get(i).getTurn();
				for (int j = start + 1; j < 4; j++) {
					if (wheel[start][2] != wheel[j][6]) {
						visited[j] = visited[start] * -1;
					}else {
						break;
					}
					start = j;
				}

				// 회전시키기
				turningTheWheel();
				Arrays.fill(visited, 0);

			}
			int total = 0;
			for(int i =0 ; i < 4 ; i++) {
				if(wheel[i][0] == 1) 
					total += Math.pow(2, i);
				
			}
			
			System.out.println("#"+ test_case + " " + total);
		}

	}

	private static void turningTheWheel() {
		int temp = 0;
		for (int i = 0; i < 4; i++) {
			if (visited[i] == 1) {
				// 시계방향
				temp = wheel[i][7];
				for (int j = 7; j > 0; j--) {
					wheel[i][j] = wheel[i][j-1];
				}
				wheel[i][0] = temp;
			} else if (visited[i] == -1) {
				// 반시계방향
				temp = wheel[i][0];
				for (int j = 0; j < 7; j++) {
					wheel[i][j] = wheel[i][j+1];
				}
				wheel[i][7] = temp;
			}

		}

	}

}
