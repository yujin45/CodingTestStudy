import java.util.HashMap;
import java.util.HashSet;


class Solution {
    // 좌표 평면 벗어나는지 체크하는 메서드
    private static boolean isValidMove(int nx, int ny){
        return 0<=nx && nx <11 && 0<= ny && ny <11;
    }
    
    // 다음 좌표 결정을 위한 해시맵 생성
    private static final HashMap<Character, int[]> location = new HashMap<>();
    
    private static void initLocation(){
        location.put('U', new int[]{0,1});
        location.put('D', new int[]{0,-1});
        location.put('L', new int[]{-1, 0});
        location.put('R', new int[]{1, 0});
    }
    
    public int solution(String dirs) {
        initLocation(); 
        int x = 5, y =5; //시작 좌표 설정
        HashSet<String> answer = new HashSet<>(); //겹치는 좌표 a->b, b->a는 1개로 처리 위함
        // 주어진 명령어올 움직이면서 좌표 저장
        for(int i = 0; i<dirs.length(); i++){
            int [] offset = location.get(dirs.charAt(i));
            int nx = x + offset[0];
            int ny = y + offset[1];
            if(!isValidMove(nx, ny)){
                // 벗어난 좌표는 인정x
                continue;
            }
            // A에서 b로 간 경우,  B에서 A도 추가해야 함(총 경로의 개수는 방향성 없음)
            answer.add(+x+" "+y+" "+nx+" "+ny);
            answer.add(nx+" "+ ny+" "+x+" "+y);
            // 좌표를 이동했으므로 업데이트
            x = nx;
            y = ny;
        }
        return answer.size()/2;
        
    }
}