import heapq

def solution(scoville, K):
    heapq.heapify(scoville)
    shake_count = 0
    while scoville[0] < K:
        if len(scoville) == 1:
            return -1
        first = heapq.heappop(scoville)
        second = heapq.heappop(scoville)
        mix = first + (second * 2)
        heapq.heappush(scoville, mix)
        shake_count += 1
        
    
    return shake_count