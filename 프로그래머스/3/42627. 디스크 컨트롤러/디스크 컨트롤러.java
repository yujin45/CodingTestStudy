import java.util.*;

class Solution {

    static class Task implements Comparable<Task> {
        int num;
        int reqTime;
        int time;

        public Task(int num, int reqTime, int time) {
            this.num = num;
            this.reqTime = reqTime;
            this.time = time;
        }

        @Override
        public int compareTo(Task other) {
            return this.time - other.time; // 작업 시간 기준 오름차순
        }
    }

    public int solution(int[][] jobs) {
        int n = jobs.length;
        int currentTime = 0;
        int tTime = 0;
        int done = 0;

        // 요청 시간 기준 정렬 후 큐에 담기
        Queue<Task> jobQueue = new LinkedList<>();
        Arrays.sort(jobs, Comparator.comparingInt(j -> j[0]));
        for (int i = 0; i < n; i++) {
            jobQueue.add(new Task(i, jobs[i][0], jobs[i][1]));
        }

        PriorityQueue<Task> readyQueue = new PriorityQueue<>(); // 작업시간 기준 최소힙

        while (done < n) {
            // 현재 시간까지 요청된 작업 모두 큐에 추가
            while (!jobQueue.isEmpty() && jobQueue.peek().reqTime <= currentTime) {
                readyQueue.offer(jobQueue.poll());
            }

            if (!readyQueue.isEmpty()) {
                Task task = readyQueue.poll();
                currentTime += task.time;
                tTime += currentTime - task.reqTime;
                done++;
            } else {
                // 대기 중인 작업이 없을 때 다음 요청 시간으로 이동
                currentTime = jobQueue.peek().reqTime;
            }
        }

        return tTime / n;
    }
}
