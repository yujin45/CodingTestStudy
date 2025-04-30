def solution(prices):
    n = len(prices)
    answer = [0] * n
    stack = []  # index를 저장

    for i in range(n):
        # 가격이 떨어지는 지점을 찾으면 그만큼 시간 계산
        while stack and prices[i] < prices[stack[-1]]:
            j = stack.pop()
            answer[j] = i - j
        stack.append(i)
    
    # 남은 인덱스는 끝까지 안 떨어진 것이므로
    while stack:
        j = stack.pop()
        answer[j] = n - 1 - j

    return answer
