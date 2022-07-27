package Y_2022.M_01.D_10;

import java.io.*;

public class Main_2447 {
	static char[][] board;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bd = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(bd.readLine());
		board = new char[N][N]; // N개의 별 넣을 배열 생성

		star(0, 0, N, false); // 위치 x, 위치 y, 크기, 센터인지 확인
		
		for(int i = 0 ; i < N;i++) {
			for(int j = 0; j < N;j++) {
				sb.append(board[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.print(sb);

	}

	static void star(int x, int y, int size, boolean center) {
		if(center) {//센터라면
			for(int i = x ; i< x+ size;i++) {//시작 위치부터 빈칸이 될 크기 더한 값까지
				for(int j = y; j < y + size; j++ ) {//시작 위치부터 빈칸이 될 크기 더한 값까지
					board[i][j] = ' ';//빈칸 지정
				}
			}
			return;
		}
		
		//크기를 나누지 못할 때
		if(size == 1) {
			board[x][y] = '*';
			return;
		}
		
		int count = 0;
		int h = size/3;
		
		for(int i = x; i < x+ size; i += h) {
			for(int j = y; j < y + size; j += h) {
				count++;
				if(count == 5) {
					star(i,j,h, true);
				}else {
					star(i,j,h,false);
				}
			}
		}
		
		
	}

}
