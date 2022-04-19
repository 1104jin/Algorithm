import java.util.ArrayList;
import java.util.Scanner;
 
class Solution {
	static int n,total ;
	static int[][] map;
	static boolean[] visited;	
	
    public static void main(String arg[]) throws Exception {
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
 
        for (int test_case = 1; test_case <= T; test_case++)
        {
        	n = sc.nextInt();
        	map = new int[n][n];
        	visited = new boolean[n];
        	total = Integer.MAX_VALUE;
        	
        	for(int i = 0; i < n ; i++) {
        		for(int j = 0; j < n ; j++) {
        			map[i][j] = sc.nextInt();
        		}
        	}
        	
        	//1. 조합을 구한다.
        	combination(0,0);
        	
        	System.out.println("#" + test_case + " " +total);
        }
 
        sc.close();
    }

	private static void combination(int cnt, int ind) {
		if(cnt == n/2) {
			total = Integer.min(total, findMinV());
			return;
		}
		
		for(int i=ind; i<n;i++) {
			visited[i] = true;
			combination(cnt+1, i+1);
			visited[i] = false;
		}
		
	}

	private static int findMinV() {
		ArrayList<Integer> fi = new ArrayList<>();
		ArrayList<Integer> se= new ArrayList<>();
		
		for(int i = 0 ; i < n ; i++) {
			if(visited[i]) {
				fi.add(i);
			}else
				se.add(i);
		}
		
		int fiCount = 0;
		int seCount = 0;
		
		for(int i = 0; i < fi.size() - 1;i++) {
			for(int j = i+1; j < fi.size();j++) {
				fiCount += map[fi.get(i)][fi.get(j)];
				fiCount += map[fi.get(j)][fi.get(i)];

				seCount += map[se.get(i)][se.get(j)];
				seCount += map[se.get(j)][se.get(i)];
				
			}
		}
		return Math.abs(fiCount - seCount);
		
		
	}
	
}
