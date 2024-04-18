
def solution(clothes):
    closet ={}
    # 리스트 2가지 요소로 가지고 올 수 있다
    # 기억해야 할 것
    # 1. for문 인자값 2개 받아올 수 있다.
    # 2. [리스트]는 더하기 연산이 가능하다 [a]+[b] = [a, b]
    for name, kind in clothes:
        if kind in closet.keys():
            # closet에 키가 이미 있으면
            closet[kind]+=[name]
        else:
            closet[kind] = [name]
    
    # A종류가 N개 B 종류가 M개일 때의 경우의 수 = (N+1)(M+1)
    answer = 1
    for kind in closet.keys():
        answer *= (len(closet[kind]) +1)
    # 아무것도 안 입었을 때 빼주기
    return answer-1