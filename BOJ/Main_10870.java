package Y_2022.M_01.D_04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10870 {
	public static int fibonacci(int n) {
		if(n == 0) return 0;
		else if(n == 1) return 1;
		else return fibonacci(n-1) + fibonacci(n-2);
	}
	public static void main(String[] args) throws Exception{
		BufferedReader bd = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(fibonacci(Integer.parseInt(bd.readLine())));
	}

}
