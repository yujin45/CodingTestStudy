import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] numbers;
	static int[] sequence;
	static StringBuilder sb;
	static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
        	numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        
        visited = new boolean[n];
        sequence = new int[m];
        sb = new StringBuilder();
        backtrack(0);
        System.out.println(sb.toString());
    }
   
    private static void backtrack(int depth) {
    	if(depth == m) {
    		for(int num : sequence) {
    			sb.append(num).append(" ");
    		}
    		sb.deleteCharAt(sb.length()-1);
    		sb.append("\n");
    		return;
    	}
    	
    	int lastUsed = -1;
    	for(int i = 0; i < n; i++) {
    		if(!visited[i] && lastUsed != numbers[i]) {
    			visited[i] = true;
    			sequence[depth] = numbers[i];
    			lastUsed = numbers[i];
    			backtrack(depth+1);
    			visited[i] = false;
    		}
    	}
    }
    
}
