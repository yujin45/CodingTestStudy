import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;


class Solution {
    public int[] solution(String[] operations) {
        Map<Integer, Boolean> validMap = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(String operation : operations){
            if(operation.startsWith("I")){
                String[] oper = operation.split(" ");
                int num = Integer.parseInt(oper[1]);
                validMap.put(num, true);
                maxHeap.add(num);
                minHeap.add(num);
            }else if(operation.equals("D -1")){
                // 최솟값 제거 
                while(!minHeap.isEmpty()){
                    int num = minHeap.poll();
                    if(validMap.get(num)){
                        validMap.put(num, false);
                        break;
                    }
                }
            }else if(operation.equals("D 1")){
                // 최댓값 제거
                while(!maxHeap.isEmpty()){
                    int num = maxHeap.poll();
                    if(validMap.get(num)){
                        validMap.put(num, false);
                        break;
                    }
                }
            }
        }
        
        int maxValue = 0;
        int minValue = 0;
        
        while(!minHeap.isEmpty()){
            int num = minHeap.poll();
            if(validMap.get(num)){
                minValue = num;
                break;
            }
        }
        
        while(!maxHeap.isEmpty()){
            int num = maxHeap.poll();
            if(validMap.get(num)){
                maxValue = num;
                break;
            }
        }
        
        
        
        int[] answer = {maxValue, minValue};
        return answer;
    }
}