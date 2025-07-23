# N을 i번 사용해서 만들 수 있는 수의 집합을 dp[i]에 저장
# dp[1] = {5}
# dp[2] = {55, 5+5, 5-5, 5*5, 5//5}
# dp[3] = {555, (55+5), (5+55), (5+5+5), ...}

# dp[i]를 구할 때는 1<= j <i에 대해서 dp[j]와 dp[i-j]의 사칙연산 조합 모두 시도
# 4개로 만든다고 하면 2개 + 2개 , 3개 + 1개 이런식으로 조합
# 모든 경우의 수 set에 저장
# i= 1~8까지 돌면서 number 있으면 그 i가 최소 횟수 됨
def solution(N, number):
    # 초기 세팅
    dp = [set() for _ in range(9)] # 8번까지 사용 가능 dp[1] ~ dp[8]
    
    for i in range(1, 9):
        # 1. N을 i번 이어 붙인 수 추가 (5, 55, 555 ...)
        dp[i].add(int(str(N) * i))
    
        # 2. 사칙연산으로 만들 수 있는 모든 수 추가
        for j in range(1, i):
            for op1 in dp[j]:
                for op2 in dp[i-j]:
                    dp[i].add(op1 + op2)
                    dp[i].add(op1 - op2)
                    dp[i].add(op1 * op2)
                    if op2 != 0:
                        dp[i].add(op1//op2)
        
        # 3. 현재 i개의 N으로 number를 만들 수 있다면 바로 return
        if number in dp[i]:
            return i
    
    return -1 # 8개 이하로 못만들면 -11