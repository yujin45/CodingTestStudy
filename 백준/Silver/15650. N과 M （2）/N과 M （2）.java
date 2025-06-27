import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static boolean[] visited;
	static int[] sequence;
	static StringBuilder sb;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
       visited = new boolean[n+1];
       sequence = new int[m];
       sb = new StringBuilder();
       backtrack(0, 1);
       System.out.println(sb.toString());
    }
    
    private static void backtrack(int depth, int start) {
    	if(depth == m) {
    		for(int num : sequence) {
    			sb.append(num).append(" ");
    		}
    		sb.deleteCharAt(sb.length()-1);
    		sb.append("\n");
    		return;
    	}
    	
    	for(int i = start; i <= n; i++) {
    		if(!visited[i]) {
    			visited[i] = true;
    			sequence[depth] = i;
    			backtrack(depth+1, i+1);
    			visited[i] = false;
    		}
    	}
    }
    
  
    
    
}
