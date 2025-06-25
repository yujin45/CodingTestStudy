import java.util.ArrayDeque;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayDeque<Integer> bridge = new ArrayDeque<>();
        for(int i = 0; i < bridge_length; i++){
            bridge.add(0);
        }
        
        ArrayDeque<Integer> trucks = new ArrayDeque<>();
        for(int truck : truck_weights){
            trucks.add(truck);
        }
        
        int done = 0;
        int time = 0;
        int currentWeight = 0;
        
        while(done < truck_weights.length){
            // 다리에서 빼내기
            int doneTruck = bridge.removeFirst();
            currentWeight -= doneTruck;
            if(doneTruck != 0) done++;
            
            if(!trucks.isEmpty()){
                // 트럭 있으면
                if(currentWeight + trucks.peekFirst() <= weight){
                    // 올릴 수 있으면
                    int nowTruck = trucks.removeFirst();
                    currentWeight += nowTruck;
                    bridge.addLast(nowTruck);
                }else{
                    // 올릴 수 없으면
                    bridge.addLast(0);
                }
            }else{
                bridge.addLast(0);
            }
            time++;
        }
        
        return time;
    }
}