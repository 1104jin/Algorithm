package self.BJ;

import java.util.Scanner;

public class Main_14891 {

	private static char[][] t;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		t = new char[4][8];
		
		for (int i = 0; i < 4; i++) {
			t[i] = sc.next().toCharArray();
		}
		
		int k = sc.nextInt();
		int[][] lotation = new int[k][2];
		for (int i = 0; i < k; i++) {
			int tN = sc.nextInt()-1;
			int d = sc.nextInt();
			
			lotation[i][0] = tN;
			lotation[i][1] = d;
		}
		
		int i = 0;
		int[][] dd = new int[][] {{0,3},{1,2},{2,1},{3,0}};
		while(i< k) {
			int[] isTrue = new int[4];
			
			int sT = lotation[i][0];
			int sD = lotation[i][1];
			isTrue[sT] = sD;
			
			//왼쪽		//시작 위치
			for (int j = sT-1; j>-1; j--) {
				if(t[sT][6] == t[j][2]) {
					break;
				}else {
					if(sD == 1) {
						isTrue[j] = -1;
						sD = -1;
						}
					else {
						isTrue[j] = 1;
						sD = 1;
						}
				}

				sT = j;
			}
			
			//오른쪽		//시작위치
			sT = lotation[i][0];
			sD = lotation[i][1];
			for (int j = sT+1; j < 4; j++) {
				if(t[sT][2] == t[j][6]) {
					break;
				}else {
					if(sD == 1) {
						isTrue[j] = -1;
						sD = -1;
					}
					else {
						isTrue[j] = 1;
						sD = 1;
					}
					}

				sT = j;
			}
			for (int j = 0; j < 4; j++) {
				if(isTrue[j] == 1)
					changeRW(j);
				else if(isTrue[j] == -1)
					changeW(j);
			}
			i++;
			
		}
		int total = 0;
		for (int j = 0; j < 4; j++) {
			if(t[j][0] == '1') {
				total += Math.pow(2, j);
			}
		}
		
		
		System.out.println(total);
	}

	private static void changeRW(int i) {
		char temp = t[i][0];
		
		for (int j = 7; j > 0; j--) {
			t[i][(j+1) % 8] = t[i][j%8];
		}
		
		t[i][1] = temp;
		
	}

	private static void changeW(int i) {
		char temp = t[i][7];
		
		for (int j = 0; j < 7; j++) {
			t[i][(j+7) % 8] = t[i][j%8];
		}
		
		t[i][6] = temp;
		
	}

}
