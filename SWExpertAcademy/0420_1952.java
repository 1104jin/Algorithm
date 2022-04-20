import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	static int[] cost = new int[4];
	static int[] monthPlan = new int[12];
	static int min;
	public static void main(String arg[]) throws Exception {
		BufferedReader bd = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int testCase = Integer.parseInt(bd.readLine());
		for(int t = 1; t <= testCase; t++) {
			st = new StringTokenizer(bd.readLine());
			
			for(int i = 0; i < 4; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(bd.readLine());
			
			for(int i = 0; i < 12 ; i++) {
				monthPlan[i] = Integer.parseInt(st.nextToken()); 
			}
			min = cost[3];
			dfs(0, 0);
			System.out.println("#" + t + " " + min);
		}

	}

	private static void dfs(int month, int cal) {
		if(min <= cal) return;
		
		if(month > 11) {
			min = Integer.min(min, cal);
			return;
		}
		
		if(monthPlan[month] == 0)  
			dfs(month+1, cal);
		else {
			//1일 사용한다면
			dfs(month+1, cal + cost[0] * monthPlan[month]);
			//1달 사용한다면
			dfs(month+1, cal + cost[1]);
			//3달 사용한다면
			dfs(month+3, cal + cost[2]);
		}
	}
}
