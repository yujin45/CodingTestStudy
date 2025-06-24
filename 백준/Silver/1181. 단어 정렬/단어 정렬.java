import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		HashSet<String> set = new HashSet<>();
		for(int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		List<String> list = new ArrayList<>(set);
		
		list.sort(Comparator
				.comparingInt(String::length)
				.thenComparing(Comparator.naturalOrder()));
		
		StringBuilder sb = new StringBuilder();
		for(String s: list){
			sb.append(s).append('\n');
		}
		
		System.out.println(sb);
	}

}
