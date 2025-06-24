import java.util.ArrayDeque;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayDeque<Integer> trucks = new ArrayDeque<>();
        for(int truck_weight : truck_weights){
            trucks.add(truck_weight);
        }
        ArrayDeque<Integer> bridge = new ArrayDeque<>();
        for(int i = 0; i < bridge_length; i++){
            bridge.addLast(0);
        }
       
        //
        int done = 0;
        int time = 0;
        int currentTotalWeights = 0;
        while(done < truck_weights.length){
            // 1초 지나는 순간 다리에서 일단 내려놓기
            int doneTruck = bridge.removeFirst();
            currentTotalWeights -= doneTruck;
            if(doneTruck != 0) done++;
            
            // 다음 트럭이 올라갈 수 있는지 확인
            if(!trucks.isEmpty()){
                int nextTruck = trucks.peekFirst();
                if(currentTotalWeights + nextTruck  <= weight){
                    bridge.addLast(nextTruck);
                    currentTotalWeights += nextTruck;
                    trucks.removeFirst();
                }else{
                    bridge.addLast(0);
                }
            }else{
                bridge.addLast(0); // 트럭 없지만 다리 유지
            }
            
            
            time++;
        }
        
        
        return time;
    }
}