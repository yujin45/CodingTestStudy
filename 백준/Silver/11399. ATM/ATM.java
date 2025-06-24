import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] times = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			times[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(times);
		
		int sum = 0;
		int total = 0;
		for(int time: times) {
			sum += time;
			total += sum;
		}
		
		System.out.println(total);
	}

}
