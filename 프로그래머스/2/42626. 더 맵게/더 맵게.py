import heapq

def solution(scoville, K):
    heapq.heapify(scoville)
    count = 0
    
    while len(scoville) > 1 and scoville[0] < K:
        # 2개 이상이고 K 보다 작은 것들이 있으면 섞기
        first = heapq.heappop(scoville)
        second = heapq.heappop(scoville)
        mixed = first + (second * 2)
        heapq.heappush(scoville, mixed)
        count += 1
    
    if scoville[0] < K:
        return -1

    return count