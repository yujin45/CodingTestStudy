
import java.util.HashMap;

class Solution {
    public int[] solution(int N, int[] stages) {
        // 나와 달랐던 점! ▼ 나는 stages를 돌면서 확인하고 없애려고 햇다. 2중 for문 됨. 
        // 스테이지별 도전자 수를 구함
        int [] challenger = new int[N+2]; // 0번 스테이지, 클리어한 n+1 스테이지까지
        for(int i = 0; i<stages.length; i++){
            challenger[stages[i]] +=1; // 스테이지를 인덱스로 처리
        }
        
        // 스테이지별 실패한 사용자 수 계산
        HashMap<Integer, Double> fails = new HashMap<>();
        double total = stages.length;
        
        // 각 스테이지를 순회하며 실패율 계산
        for(int i = 1; i<=N; i++){
            if(challenger[i] == 0){
                // 도전한 사람이 없는 경우, 실패율은 0
                fails.put(i, 0.);
            }else{
                fails.put(i, challenger[i]/total); //실패율을 구함
                total -= challenger[i]; // 다음 스테이지 실패율 구하기 위해 현재 스테이지 인원 뺌
            }
        }
        
        // 실패율이 높은 스테이지부터 내림차순으로 정렬
        return fails.entrySet().stream().sorted((o1, o2)->Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
        
        
    }
}