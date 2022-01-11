package Y_2022.M_01.D_12;

import java.io.*;
import java.util.StringTokenizer;

public class mna_5086 {

	public static void main(String[] args) throws Exception {
		BufferedReader bd = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(bd.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			if(M == 0 && N == 0 )
				break;
			String isTrue = " ";		//1: factor, 2: multiple, 3: neither
			
			if (M > N) {
				if (M % N == 0)
					isTrue = "multiple";
				else
					isTrue = "neither";
			} else if (M <= N) {
				if (N % M == 0)
					isTrue = "factor";
				else
					isTrue = "neither";
			} else
				isTrue = "neither";
			
			System.out.println(isTrue);
		}

	}

}
