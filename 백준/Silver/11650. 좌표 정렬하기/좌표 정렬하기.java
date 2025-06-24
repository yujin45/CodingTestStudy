import java.util.*;
import java.io.*;


public class Main {
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		List<int[]> list = new ArrayList<>();
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new int[] {x, y});
		}
		
		list.sort(Comparator.comparingInt((int[] a)-> a[0])
				.thenComparingInt((int[] a )-> a[1]));
		
		
		StringBuilder sb = new StringBuilder();
		for(int[] point :list) {
			sb.append(point[0]).append(" ").append(point[1]).append("\n");
		}

		System.out.println(sb);
	}

}
