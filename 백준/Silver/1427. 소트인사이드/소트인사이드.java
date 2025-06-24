import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        Character[] digits = new Character[input.length()];
        
        for(int i = 0; i < input.length(); i++) {
        	digits[i] = input.charAt(i);
        }
        
        //Arrays.sort(digits, Comparator.reverseOrder());
        Arrays.sort(digits, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for(char c : digits) {
        	sb.append(c);
        }
        
        System.out.print(sb);
        
    }
}
