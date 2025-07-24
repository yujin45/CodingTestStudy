import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> numbersList = new ArrayList<>();
        for(int num : numbers){
            numbersList.add(String.valueOf(num)); // 체크
        }
        numbersList.sort((o1, o2) -> (o2+o1).compareTo(o1+o2)); // 외워
        StringBuilder sb = new StringBuilder();
        for(String num : numbersList){
            sb.append(num);
        }
        
        String answer = sb.toString();
        return answer.startsWith("0") ? "0" : answer;
    }
}

// import java.util.*;

// class Solution {
//     public String solution(int[] numbers) {
//         String[] nums = new String[numbers.length];
//         for(int i = 0; i < numbers.length; i++){
//             nums[i] = String.valueOf(numbers[i]);
//         }
        
//         Arrays.sort(nums, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
//         if(nums[0].equals("0")) return "0";
        
//         StringBuilder sb = new StringBuilder();
//         for(String num : nums){
//             sb.append(num);
//         }
//         return sb.toString();
//     }
// }