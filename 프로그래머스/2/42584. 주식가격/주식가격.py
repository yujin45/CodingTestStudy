from collections import deque

def solution(prices):
    prices = deque(prices)
    answer = []
    
    while prices:
        # price 뽑아서 확인할거임
        price = prices.popleft()
        sec = 0 # 초 초기화    
        # 남은 애들이랑 비교
        for p in prices:
            sec+=1 # 비교하는 순간 1초 흐른 것
            if p < price:
                # 다음 순번이 내 가격보다 작으면 하락한 것
                break
        answer.append(sec)
    return answer    