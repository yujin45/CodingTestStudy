def solution(prices):
    n = len(prices)
    answer = [0] * n 
    stack = []
    
    for i in range(n):
        # 가격이 떨어지는 시점 찾으면 그만큼 시간 계산
        while stack and prices[i] < prices[stack[-1]]:
            # 떨어지는 시점
            j = stack.pop()
            answer[j] = i - j 
        stack.append(i)
    
    while stack:
        j = stack.pop()
        answer[j] = n - 1 - j
        
    return answer