import java.util.Arrays;
import java.util.Scanner;

public class Main_2798 {
    static int n, m;
    static int[] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        board = new int[n];

        for(int i = 0; i < n ; i++){
            board[i] = sc.nextInt();
        }

        System.out.println(check());

    }
    private static int[] v = new int[3];
    private static int check() {
        int total = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int l = j + 1; l < n; l++) {
                    int sum = board[i] + board[j] + board[l];

                    if (sum == m) return sum;
                    if (sum < m && sum > total)
                        total = sum;

                }
            }
        }
        return total;
    }
}
