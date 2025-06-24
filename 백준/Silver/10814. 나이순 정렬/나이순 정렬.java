import java.io.*;
import java.util.*;

class Member {
	int id;
	int age;
	String name;
	
	public Member(int id, int age, String name) {
		this.id = id;
		this.age = age;
		this.name = name;
	}
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        List<Member> members = new ArrayList<>();
        
        for(int i = 0; i < N; i ++) {
        	// 가입 i, 나이 age, 이름 name
        	String[] input = br.readLine().split(" ");
        	members.add(new Member(i, Integer.parseInt(input[0]), input[1]));	
        }
        
        members.sort(Comparator
        		.comparingInt((Member m) -> m.age)
        		.thenComparingInt((Member m)-> m.id));
        
        StringBuilder sb = new StringBuilder();
        for(Member m : members) {
        	sb.append(String.valueOf(m.age))
        	.append(" ")
        	.append(m.name)
        	.append("\n");
        }
        System.out.print(sb);
    }
}
