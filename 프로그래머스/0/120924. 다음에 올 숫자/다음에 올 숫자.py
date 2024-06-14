def solution(common):
     # 공차를 계산
    d = common[1] - common[0]

    # 공비를 안전하게 계산
    if common[0] != 0:
        r = common[1] // common[0]
    else:
        r = None  # 초기화만 하고 나중에 결정
    
    # 등차수열인지 확인
    if common[2] - common[1] == d:
        return common[-1] + d
    else:
        # 등비수열인지 확인, common[0]이 0이 아닐 때
        if r is not None:
            return common[-1] * r
        # 공비를 나중에 결정하는 경우 (common[0]이 0인 경우)
        else:
            r = common[2] // common[1]
            return common[-1] * r
    
    