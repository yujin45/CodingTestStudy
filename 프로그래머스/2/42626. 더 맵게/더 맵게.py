import heapq

def solution(scoville, K):
    heapq.heapify(scoville)
    shake_time = 0
    
    while len(scoville) > 1 and scoville[0] < K:
        # 2개 이상 있거나 K보다 작을 경우만 썪기
        first = heapq.heappop(scoville)
        second = heapq.heappop(scoville)
        shake = first + (second * 2)
        heapq.heappush(scoville, shake)
        shake_time += 1
    
    if scoville[0] < K:
        # 모든 음식 K이상 못하는 경우
        return -1
    return shake_time