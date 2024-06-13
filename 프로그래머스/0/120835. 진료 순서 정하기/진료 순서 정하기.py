
def solution(emergency):
    # 응급 순서로 딕셔너리 만들기 
    e_sorted = sorted(emergency, reverse=True)
    
    dict = {}
    for i, e in enumerate(e_sorted):
        dict[e] = i+1
    
    answer = []
    for e in emergency:
        answer.append(dict.get(e))

    return answer