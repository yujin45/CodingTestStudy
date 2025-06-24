import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] tokens = br.readLine().split(" ");
        int[] numbers = new int[3];
        for(int i = 0; i < 3; i++) {
        	numbers[i] = Integer.parseInt(tokens[i]);
        }
        Arrays.sort(numbers);
     
        System.out.print(numbers[1]);
    }
}
