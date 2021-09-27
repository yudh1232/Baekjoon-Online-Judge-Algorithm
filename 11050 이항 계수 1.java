import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader((System.in)));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int answer = factorial(n) / factorial(n - k) / factorial(k);
		System.out.println(answer);
	}

	private static int factorial(int n) {
		if (n == 0 || n == 1) return 1;
		return n * factorial(n - 1);
	}
	
}
