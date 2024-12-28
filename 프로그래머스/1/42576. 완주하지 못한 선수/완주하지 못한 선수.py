import collections
def solution(participant, completion):
    answer = ''
    # participant -1 = completion
    # 동명이인 있을 수 있음
    
    participant_dict = collections.Counter(participant)
    #print(participant_dict)
    for c in completion:
        participant_dict[c]-=1
    for k in participant_dict.keys():
        if participant_dict[k] == 1:
            answer = k
    
    return answer