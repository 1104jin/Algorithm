import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader bd = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bd.readLine());
		
		int testcase = Integer.parseInt(st.nextToken());
		for(int t = 1; t <= testcase ; t++) {
			//값 받기
			int total = 0;
			st = new StringTokenizer(bd.readLine());
			for(int i = 0; i < 10 ; i++) {
				int num = Integer.parseInt(st.nextToken());
				if(num % 2 == 1) {
					total += num; 
				}
			}
			System.out.println("#" + t + " " + total);
		}

	}

}
