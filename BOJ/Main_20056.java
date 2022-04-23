import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] dd = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };

	static class fireball {
		private int r;
		private int c;
		private int m;
		private int s;
		private int d;
		
		public fireball(int r, int c ,int m, int s, int d) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}

		
	}
	
	

	public static void main(String[] args) throws IOException {
		BufferedReader bd = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bd.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		List<fireball>[][] map = new List[n][n];
		List<fireball> list = new ArrayList<>();
		
		for(int i = 0 ;i< n;i++) {
			for(int j =0;j<n;j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		
		//리스트에 값을 넣어준다.
		for(int i = 0; i < m;i++) {
			st = new StringTokenizer(bd.readLine());
			int ri = Integer.parseInt(st.nextToken());
			int ci = Integer.parseInt(st.nextToken());
			int mi = Integer.parseInt(st.nextToken());
			int si = Integer.parseInt(st.nextToken());
			int di = Integer.parseInt(st.nextToken());
			
			list.add(new fireball(ri-1, ci-1, mi,si,di));
		}
		
		//이동시키기
		//맵에 값이  넣기
		//k번만큼 반복
		for(int move = 0; move<k;move++) {
			for(int i = 0; i< list.size();i++) {
				fireball fire = list.get(i);
				int nx = (n + fire.r + dd[fire.d][0] * (fire.s %n))%n;
				int ny = (n + fire.c + dd[fire.d][1] * (fire.s % n))%n; 
//				
//				//범위 넘어서면 넣기
//				if(nx >= n) {
//					nx %= n;
//				}else if(nx < 0) {
//					nx %= n;
//				}
//				
//				if(ny >= n) {
//					ny %= n;
//				}else if(ny < 0) {
//					ny %= n;
//				}
//				
				fire.r = nx;
				fire.c = ny;
				map[nx][ny].add(fire);
				
			}
			
			//count 두개 이상
			for(int i = 0; i < n ; i++) {
				for(int j = 0; j < n; j++) {
					//하나인 부분
					if(map[i][j].size() == 1) map[i][j].clear();
					//두개 이상인 부분
					if(map[i][j].size() > 1) {
						//맨 앞 정보 넣기
						boolean even = map[i][j].get(0).d % 2 == 0 ? true:false;
						boolean odd = map[i][j].get(0).d % 2 == 1 ? true:false;
						
						int mSum = 0, sSum = 0;
						for(int fireballCnt = 0; fireballCnt < map[i][j].size();fireballCnt++) {
							mSum += map[i][j].get(fireballCnt).m;
							sSum += map[i][j].get(fireballCnt).s;
							
							even = even & map[i][j].get(fireballCnt).d % 2 == 0?true:false;
							odd = odd & map[i][j].get(fireballCnt).d % 2 == 1?true:false;
							
							list.remove(map[i][j].get(fireballCnt));
						}
						
						mSum /= 5;
						sSum /= map[i][j].size();
						map[i][j].clear();
						if(mSum == 0) continue;
						
						
						
						
						if(even|odd) {
							for(int z = 0 ; z < 8;z += 2 ) {
								list.add(new fireball(i, j, mSum, sSum, z));
							}
						}else {
							for(int z = 1 ; z < 8;z += 2 ) {
								list.add(new fireball(i, j, mSum, sSum, z));
							}
						}
						
					}
				}
			}
			
		}
		int total = 0;
		for(int i = 0; i< list.size();i++) {
			total += list.get(i).m;
		}

		System.out.println(total);

	}
	
}
