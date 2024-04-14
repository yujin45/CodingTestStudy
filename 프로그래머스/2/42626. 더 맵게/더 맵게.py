import heapq

def solution(scoville, K):
    heapq.heapify(scoville) # 힙을 만들어주기 
    mix_count =0
    # 리스트 내포 사용하기
    # all 함수는 iterable의 모든 요소 참인지 검사함
    #while not all(item >= K for item in scoville):
    # any하면 하나라도 참이면 True
    while any(item < K for item in scoville):
        # 섞어야 하는 최소 횟수 return
        min1 = heapq.heappop(scoville) # 가장 맵지 않은 음식 스코빌
        if min1 >=K:
            break
        # 위에서 min1 뽑아서 len이 0일 때로 봐주어야 함    
        if len(scoville) == 0:
            # 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다!! 조건!!
            mix_count = -1
            break
        # 모든 음식의 스코빌 지수가 K 이상이 될 때까지 
        
        min2 = heapq.heappop(scoville) # 2번째로 맵지 않은 음식 스코빌
        heapq.heappush(scoville, min1+min2*2) # 섞은 음식의 스코빌 지수 넣기
        mix_count +=1
        
    return mix_count