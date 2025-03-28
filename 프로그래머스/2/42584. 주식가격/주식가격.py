from collections import deque

def solution(prices):
    n = len(prices)
    answer = [0]*n
    stack = []
    
    for i in range(n):
        # 현재 가격이 이전 가격보다 떨어졌다면 스택 처리
        # stack에는 인덱스 값을 넣어줌
        while stack and prices[stack[-1]] > prices[i]:
            # 만약 이전 가격보다 현재가 작으면
            top = stack.pop()
            answer[top] = i - top # 현재 인덱스 - 떨어지기 전 인덱스
        stack.append(i)
    
    # 끝까지 안 떨어진 애들 처리
    while stack:
        top = stack.pop()
        answer[top] = n - 1 - top
    
    return answer
            
            