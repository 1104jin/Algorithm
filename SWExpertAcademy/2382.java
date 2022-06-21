import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	private static class misang{
		private int x;
		private int y;
		private int count;
		private int d;
		
		public misang(int x, int y,int count, int d) {
			super();
			this.x = x;
			this.y = y;
			this.count = count;
			this.d = d;
		}
		public misang() {
		}
		
	}
	static List<misang>[][] map;
	static List<misang> ms;
	static int n, m,k;
	static int[][] dd = {{},{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bd = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int TestCase = Integer.parseInt(bd.readLine());
		
		for(int t = 1; t <= TestCase ; t++) {
			st = new StringTokenizer(bd.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			ms = new ArrayList<>();
			map = new List[n][n];
			for(int i = 0; i < n ; i++) {
				for(int j = 0; j < n; j++) {
					map[i][j] = new ArrayList();
				}
			}
			
			for(int i = 0; i < k ; i ++) {
				st = new StringTokenizer(bd.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				
				ms.add(new misang(x, y,count, d));
			}
			
			//m번 반복
			for(int turn = 0; turn < m;turn++) {
				//리스트 사이즈만큼
				for(misang m : ms) {
					//이동
					int nx = m.x + dd[m.d][0];
					int ny = m.y + dd[m.d][1];
					
					//약품과 만난다면
					if(nx == 0 || nx == n-1 || ny == 0 || ny == n-1) {
						m.count /=2;
						if(m.d == 1) {
							m.d = 2;
						}else if(m.d == 2) {
							m.d = 1;
						}else if(m.d == 3) {
							m.d = 4;
						}else if(m.d == 4) {
							m.d = 3;
						}
					}
					
					//m.count가 영이 아니라면
					if(m.count != 0) {
						//map에 추가
						map[nx][ny].add(new misang(nx,ny,m.count,m.d));	
					} 
				}
				//리스트 초기화
				ms.clear();
				
				//맵 사이즈 만큼 반복 개수 여러개인 거 확인
				for(int i = 0; i < n ; i++) {
					for(int j = 0; j < n; j++) {
						//만약 사이즈가 1이면 
						misang m = new misang();
						if(map[i][j].size() == 0) continue;
						else if(map[i][j].size() == 1) {
							m = map[i][j].get(0);
						}else if(map[i][j].size() >= 2) {
							//갯수만큼 반복
							int micnt = 0; //미생물 카운트
							int mid = 0;//방향
							int mitotal = 0; //합친값
							
							for(misang mm : map[i][j]) {
								mitotal += mm.count;
								if(micnt < mm.count) {
									micnt = mm.count;
									mid = mm.d;
								}
							}
							
							m.x = i;
							m.y = j;
							m.d = mid;
							m.count = mitotal; 
							
							
						}
						//값 리스트에 추가
						ms.add(m);
						
						//맵 초기화
						map[i][j].clear();
					}
				}
				
				
			}
			
			//합 추출
			int total = 0;
			
			for(int i = 0; i < ms.size() ; i++) {
				total += ms.get(i).count;
			}

			System.out.println("#"+t+" "+total);
			
		}
		
	}

}
