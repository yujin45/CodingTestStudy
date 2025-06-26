import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        List<Integer> list = new ArrayList<>();
        for(int rock : rocks) list.add(rock);
        list.add(distance); // 마지막 도착 지점 추가

        long left = 1;
        long right = distance; 
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2; // 최소 거리 후보
            int removed = 0;
            int prev = 0;

            for (int rock : list) {
                if (rock - prev < mid) {
                    removed++; // 최소 거리 못 만족하니까 바위 제거
                } else {
                    prev = rock;
                }
            }

            if (removed > n) {
                right = mid - 1; // 너무 많이 제거했으니 최소 거리 줄이기
            } else {
                answer = mid; // 가능한 거리 → 더 큰 거리도 시도
                left = mid + 1;
            }
        }

        return (int) answer;
    }
}
