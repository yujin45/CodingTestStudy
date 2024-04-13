def solution(participant, completion):
    # 참여 선수, 완주 선수들 이름 담은 배열 받음
    # 완주하지 못한 1명 선수 이름 return
    # 1 <= participant <= 100,000
    # participant -1 = completion
    # 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
    # 참가자 중에는 동명이인이 있을 수 있습니다. = 중복 이름 가능
    
    # 두 배열을 비교하여 없는 사람을 찾아야 함
    # participant로  이름 : 몇명 만들고 completion을 key값으로 value - 1을 시켜 순회해보기.
    # 마지막에 value가 1인 사람이 완주하지 못한 사람
    answer = ''
    participant_counts = {}
    for p in participant:
        if p in participant_counts:
            participant_counts[p] +=1
        else:
            participant_counts[p] = 1
    #print(participant_counts)
    
    for c in completion:
        if c in participant_counts:
            participant_counts[c] -=1
    
    for a in participant_counts:
        #print(a)
        if participant_counts[a] == 1:
            answer = a
    #answer = ''
    return answer