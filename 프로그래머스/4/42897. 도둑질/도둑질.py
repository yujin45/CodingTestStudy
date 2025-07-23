def operate(room):
    n = len(room)
    if n == 0:
        return 0
    if n == 1:
        return room[0]
    if n == 2:
        return max(room[0], room[1])
    
    dp = [0] * n
    dp[0] = room[0]
    dp[1] = max(room[0], room[1])
    for i in range(2, n):
        dp[i] = max(dp[i-1], dp[i-2] + room[i])
    
    return dp[-1]

def solution(money):
    if len(money) == 3:
        # 3개만 있는 마을이면 바로 최댓값 리턴
        return max(money)
    
    # 4개 이상인 곳은 체크 필요
    return max(operate(money[:-1]), operate(money[1:]))