def solution(participant, completion):
    pcount = {}
    
    for p in participant:
        # 딕셔너리 만들기
        if p in pcount:
            # 이미 있으면
            pcount[p] +=1 # 1증가
        else:
            pcount[p] = 1 # 1넣기
    
    for c in completion:
        if pcount[c] == 1:
            # 1명인 경우 지우기
            del pcount[c]
        else:
            pcount[c] -=1 # 2명 이상이면 하나 지우기
    
    # 남은 키값이 정답
    answer = list(pcount.keys())[0]
            
  
    return answer