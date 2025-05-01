import heapq

def solution(scoville, K):
    heapq.heapify(scoville)
    answer = 0
    while scoville[0]< K and len(scoville) >= 2:
        first = heapq.heappop(scoville)
        second = heapq.heappop(scoville)
        mix = first + second * 2
        heapq.heappush(scoville, mix)
        answer += 1
    check = heapq.heappop(scoville)
    if check < K:
        return -1
    return answer