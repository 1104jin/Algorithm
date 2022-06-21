package Y_2022.M_01.D_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class factorial_10872 {
	public static int factorial(int n) {
		if(n <= 1) return 1;
		else return factorial(n-1) * n; 
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bd = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bd.readLine());
		System.out.println(factorial(n));

	}

}
