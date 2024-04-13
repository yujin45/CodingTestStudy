# 전날과 완전 똑같으면 안됨
#  각 종류별로 최대 1가지 의상만 착용
#  하루에 최소 한 개의 의상은 입습니다.


def solution(clothes):
    hash = {}
    for c in clothes:
        if c[1] not in hash:
        # 키 없으면 만들어주기
            hash[c[1]] = list()
        hash[c[1]].append(c[0])
        
    #print(hash)
    # 키포인트
    # # A의 종류가 N개, B의 종류가 M개 일 때 가능한 모든 경우의 수 (N+1)(M+1)
    
    
    answer = 1
    for key, value in hash.items():
        #print(value)
        answer *= (len(value) + 1)
        
    return answer -1